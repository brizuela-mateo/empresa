package model.response;
//Response ListaProductos -> Lista de response producto
//Retornar una clase ResponseProducto
//Carpeta builder contruir response producto, objeto producto y construir el response producto, investigar las formas de hacer @builder, usar en mi service

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//implements serializable en response jsonproporty por atributo categoria Id, CONSTANTE MAYUS
public class ProductResponse implements Serializable {

        private Integer id;
        private String descripcion;
        @JsonProperty("categoria Id")
        private Integer categoriaId;
        private String nombre;
        private BigDecimal precio;

}
