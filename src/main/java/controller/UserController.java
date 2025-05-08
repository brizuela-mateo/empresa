package controller;

import jakarta.validation.Valid;
import model.Product;
import model.User;
import model.request.RestRequestUpdateNumber;
import model.response.RestResponseUpdateNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.IProductService;
import service.IUserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userApi")
//@Validated
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IProductService productService;

    @GetMapping(value="/listUsers")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        //return ResponseEntity.ok(userService.getUserById(id));
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value="/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder field = new StringBuilder();
            errors.forEach(error -> {field.append(error.getDefaultMessage()).append(",");});

            /*1
            for (FieldError error : errors) {
                field.append(error.getField()).append(".").append(error.getDefaultMessage()).append("\n");
            }*/
            return new ResponseEntity<>(field.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value="/updateUser")
    public ResponseEntity<String> updateUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping(value="/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody Integer id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    public enum Calification{
        BAD(1),
        MEDIUM(2),
        GOOD(3),
        GREAT(4);

        private int value;

        Calification(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
    @PostMapping(value = "/{id}/resenar/{productId}")
    public ResponseEntity<String> reviewProduct(@PathVariable Integer id,
                                                @RequestParam (required = true) Integer productId,
                                                @RequestParam (name = "calification", required = true) Calification calification,
                                                @RequestParam (required = false) String comentario){
        try {
            userService.addReview(id, productId, calification.getValue(), comentario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value="/updateNumber/{id}/")
    public RestResponseUpdateNumber updateNumber(@RequestBody RestRequestUpdateNumber restRequestUpdateNumber, @PathVariable Integer id) {
        return userService.changeNumber(restRequestUpdateNumber, id);
    }

}
