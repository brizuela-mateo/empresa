package dao;

import model.DetallePedido;
import model.DetallePedidoJoin;

import java.util.List;

public interface IDetallePedidoDao {
    public List<DetallePedidoJoin> obtenerDetallePedidosJoin(String estadoPedido);
    public List<DetallePedido> obtenerDetallePedidos();
}
