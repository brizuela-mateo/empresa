package rowmapper;

import model.DetallePedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetallePedidoMapper implements RowMapper<DetallePedido> {
    public DetallePedido mapRow(ResultSet rs, int rowNum) throws SQLException {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setNombreUsuario(rs.getString("nombre_usuario"));
        detallePedido.setEstadoPedido(rs.getString("estado_pedido"));
        detallePedido.setNombreCategoria(rs.getString("nombre_categoria"));
        return detallePedido;
    }
}
