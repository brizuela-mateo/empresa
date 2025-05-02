package dao;

import model.DetallePedido;

import java.util.List;

public interface IDetallePedidoDao {
    public List<DetallePedido> obtenerDetallePedidos(String estadoPedido);
}
