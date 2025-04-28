package dao;

import model.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> getAllProducts();

    Product getProductById(Integer productId);
}
