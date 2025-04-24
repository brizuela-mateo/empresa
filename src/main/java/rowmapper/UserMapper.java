package rowmapper;

import model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setNombre(rs.getString("nombre"));
        user.setEmail(rs.getString("email"));
        user.setTelefono(rs.getInt("telefono"));
        return user;
    }
}
