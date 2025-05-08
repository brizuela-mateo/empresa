package controller;

import model.DetallePedido;
import model.DetallePedidoJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        ENTREGADO,
        TODOS
    }

    @GetMapping(value = "/detalles")
    public ResponseEntity<List<DetallePedidoJoin>> listarPedidosPorCategoria(@RequestParam("categoria") Categoria categoria) {
        return ResponseEntity.ok(detallePedidoService.getDetallePedidosJoin(String.valueOf(categoria)));
    }

    @GetMapping(value = "/detallePedidos")
    public ResponseEntity<List<DetallePedido>> listarPedidos() {
        try{
            return new ResponseEntity<List<DetallePedido>>(detallePedidoService.getDetallePedidos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
