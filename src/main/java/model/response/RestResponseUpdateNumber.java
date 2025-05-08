package model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponseUpdateNumber {
    private Integer id;
    @JsonProperty("Nombre completo:")
    private String nombre;
    private Integer telefono;
}
