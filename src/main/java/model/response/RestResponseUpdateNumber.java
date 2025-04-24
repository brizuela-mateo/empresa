package model.response;

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
    private String nombre;
    private String email;
    private Integer telefono;
}
