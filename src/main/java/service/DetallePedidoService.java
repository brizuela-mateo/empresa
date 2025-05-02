package service;

import dao.IDetallePedidoDao;
import model.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    IDetallePedidoDao detallePedidoDao;

    @Override
    public List<DetallePedido> getDetallePedidos(String estadoPedido) {
        return detallePedidoDao.obtenerDetallePedidos(estadoPedido);
    }
}
