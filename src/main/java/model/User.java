package model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2, max = 5, message = "Nombre corto")
    private String nombre;

    @Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]+", message = "Tiene que ser un correo gmail")
    private String email;

    @NotNull(message = "Desde ahora el telefono no puede ser nulo")
    private Integer telefono;
}
