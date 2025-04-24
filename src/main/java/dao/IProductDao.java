package dao;

import model.Product;
import model.User;

import java.util.List;

public interface IProductDao {
    public List<Product> getAllProducts();
}
