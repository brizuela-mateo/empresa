package dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rowmapper.UserMapper;

import java.util.List;

@Repository
public class UserDao implements IUserDao {

    @Autowired
    //@Qualifier("jdbctemplate")
    private JdbcTemplate jdbcTemplate;

    private final UserMapper userMapper = new UserMapper();

    @Override
    public int createUser(User user){
        return jdbcTemplate.update("INSERT INTO usuario (id, nombre, email, telefono)  " +
                "VALUES (?, ?, ?, ?)", user.getId(), user.getNombre(), user.getEmail(), user.getTelefono());
    }

    @Override
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addReview(Integer id, Integer productId, int calification, String comentario) {
        String sql = "insert into resena (usuario_id, producto_id, comentario, calificacion) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, id, productId, comentario, calification);
    }

    @Override
    public void updateUser(User user){
        String sql = "UPDATE usuario SET nombre = ?, email = ?, telefono = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getNombre(), user.getEmail(), user.getTelefono(), user.getId());
    }

    @Override
    public List<User> listUsers() {
        String sql = "SELECT * FROM usuario";
        return jdbcTemplate.query(sql, userMapper);
    }

    @Override
    public User getUserById(Integer id) throws DataAccessException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userMapper, id);
    }

}
