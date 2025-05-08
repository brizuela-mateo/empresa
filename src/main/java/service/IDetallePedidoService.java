package service;

import model.DetallePedido;
import model.DetallePedidoJoin;

import java.util.List;

public interface IDetallePedidoService {
    public List<DetallePedidoJoin> getDetallePedidosJoin(String estadoPedido);
    public List<DetallePedido> getDetallePedidos();
}
