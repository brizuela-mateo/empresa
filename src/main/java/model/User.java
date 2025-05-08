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
    @Size(min = 2, max = 5, message = "El nombre tiene que estar entre 2 y 5 caracteres")
    private String nombre;

    @Pattern(regexp = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]+", message = "Tiene que ser un correo de gmail válido")
    private String email;

    @NotNull(message = "El telefono no puede ser nulo")
    private Integer telefono;
}
