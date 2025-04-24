package service;

import dao.IProductDao;
import model.Product;
import model.builder.ProductBuilder;
import model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductDao productDao;

    @Autowired
    ProductBuilder productBuilder;

    public List<ProductResponse> getAllProducts() {
        return productBuilder.buildListResponse(productDao.getAllProducts());
    }

}
