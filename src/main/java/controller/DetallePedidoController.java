package controller;

import model.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DetallePedidoService;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class DetallePedidoController {

    @Autowired
    DetallePedidoService detallePedidoService;

    public enum Categoria {
        PREPARADO,
        ENVIADO,
        ENTREGADO
    }

    @GetMapping(value = "/detalles")
    public ResponseEntity<List<DetallePedido>> listarPedidosPorCategoria(@RequestParam("categoria") Categoria categoria) {
        return ResponseEntity.ok(detallePedidoService.getDetallePedidos(String.valueOf(categoria)));
    }

}
