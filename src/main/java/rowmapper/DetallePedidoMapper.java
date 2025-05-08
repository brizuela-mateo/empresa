package rowmapper;

import model.DetallePedidoJoin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetallePedidoMapper implements RowMapper<DetallePedidoJoin> {
    public DetallePedidoJoin mapRow(ResultSet rs, int rowNum) throws SQLException {
        DetallePedidoJoin detallePedidoJoin = new DetallePedidoJoin();
        detallePedidoJoin.setNombreUsuario(rs.getString("nombre_usuario"));
        detallePedidoJoin.setEstadoPedido(rs.getString("estado_pedido"));
        detallePedidoJoin.setNombreCategoria(rs.getString("nombre_categoria"));
        return detallePedidoJoin;
    }
}
