package model.builder;

import lombok.Builder;
import model.Product;
import model.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBuilder {

    public List<ProductResponse> buildListResponse(List<Product> products){

        List<ProductResponse>  productsresponse = new ArrayList<>();

        for (Product product : products) {
            ProductResponse response = ProductResponse.builder()
                    .id(product.getId())
                    .nombre(product.getNombre())
                    .precio(product.getPrecio())
                    .categoriaId(product.getCategoriaId())
                    .descripcion(product.getDescripcion())
                    .build();
            productsresponse.add(response);
        }
        
        return productsresponse;
    }

}


