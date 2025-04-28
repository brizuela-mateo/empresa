package service;

import model.Product;
import model.response.ProductResponse;

import java.util.List;

public interface IProductService {
    public List<ProductResponse> getAllProducts();
    Product getProductById(Integer productId);
}
