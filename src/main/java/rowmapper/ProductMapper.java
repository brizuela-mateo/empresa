package rowmapper;

import model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int  rowNum) throws SQLException{
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setNombre(rs.getString("nombre"));
        product.setDescripcion(rs.getString("descripcion"));
        product.setCategoriaId(rs.getInt("categoria_id"));
        product.setPrecio(rs.getBigDecimal("precio"));
        return product;
    }
}
