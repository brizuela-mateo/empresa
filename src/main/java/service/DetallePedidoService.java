package service;

import dao.IDetallePedidoDao;
import model.DetallePedido;
import model.DetallePedidoJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    IDetallePedidoDao detallePedidoDao;

    @Override
    public List<DetallePedidoJoin> getDetallePedidosJoin(String estadoPedido) {
        return detallePedidoDao.obtenerDetallePedidosJoin(estadoPedido);
    }

    @Override
    public List<DetallePedido> getDetallePedidos() {
        return detallePedidoDao.obtenerDetallePedidos();
    }
}
