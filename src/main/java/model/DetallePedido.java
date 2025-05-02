package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {
    private String nombreUsuario;
    private String estadoPedido;
    private String nombreCategoria;
}
