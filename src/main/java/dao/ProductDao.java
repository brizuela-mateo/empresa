package dao;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import rowmapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao implements IProductDao {


    @Autowired
    @Qualifier("jdbctemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM producto", new ProductMapper() {});
    }

    @Override
    public Product getProductById(Integer productId) {
        return jdbcTemplate.queryForObject("SELECT * FROM producto WHERE id = ?", new ProductMapper(){}, productId);
    }


}
