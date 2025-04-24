package controller;

import model.User;
import model.request.RestRequestUpdateNumber;
import model.response.RestResponseUpdateNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IUserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(value="/listUsers")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping(value="/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping(value="/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @PatchMapping(value="/updateNumber/{id}/")
    public RestResponseUpdateNumber updateNumber(@RequestBody RestRequestUpdateNumber restRequestUpdateNumber, @PathVariable Integer id) {
        return userService.changeNumber(restRequestUpdateNumber, id);
    }

    @DeleteMapping(value="/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody Integer id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }


}
