package controller;


import model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IProductService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping(value = "/getProducts")
    public ResponseEntity<List<ProductResponse>> get() {
        return ResponseEntity.ok(productService.getAllProducts());
    };

}

