package service;

import model.response.ProductResponse;

import java.util.List;

public interface IProductService {
    public List<ProductResponse> getAllProducts();
}
