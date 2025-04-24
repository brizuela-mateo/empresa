package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
//implements serializable en response jsonproporty por atributo categoria Id, CONSTANTE MAYUS
public class Product {
    //@NonNull
    private Integer id;
    private String descripcion;
    private Integer categoriaId;
    //@NonNull
    private String nombre;
    //@NonNull
    private BigDecimal precio;
}
