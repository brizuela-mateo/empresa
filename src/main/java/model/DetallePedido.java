package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
    private Integer id;
    private Integer pedido_id;
    private Integer producto_id;
    private int cantidad;
    private double subtotal;
    private String estado;
}
