package dao;

import model.DetallePedido;
import model.DetallePedidoJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import rowmapper.DetallePedidoMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class DetallePedidoDao implements IDetallePedidoDao {

    private final DetallePedidoMapper detallePedidoMapper = new DetallePedidoMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<DetallePedidoJoin> obtenerDetallePedidosJoin(String estadoPedido) {
        String sql = "select us.nombre as nombre_usuario," +
                "dp.estado as estado_pedido, " +
                "ca.nombre as nombre_categoria " +
                "from detalle_pedido dp " +
                "join pedido pe on pe.id = dp.pedido_id " +
                "join usuario us on us.id = pe.usuario_id " +
                "join producto pr on pr.id = dp.producto_id " +
                "join categoria ca on ca.id = pr.categoria_id ";
        if (!estadoPedido.equals("TODOS")) {
            sql += "where dp.estado = :estadoPedido";
        }

        Map<String, Object> params = Collections.singletonMap("estadoPedido", estadoPedido);
        return namedParameterJdbcTemplate.query(sql,
                params,
                detallePedidoMapper) ;
    }

    @Override
    public List<DetallePedido> obtenerDetallePedidos() {
        String sql = "SELECT * FROM detalle_pedido";
        //return plantilla.query("select * from Facturas", new BeanPropertyRowMapper<Factura>(Factura.class));
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<DetallePedido>(DetallePedido.class));
    }

}
