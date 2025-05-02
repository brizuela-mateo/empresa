package service;

import model.DetallePedido;

import java.util.List;

public interface IDetallePedidoService {
    public List<DetallePedido> getDetallePedidos(String estadoPedido);
}
