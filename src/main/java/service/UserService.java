package service;

import dao.IUserDao;
import dao.ProductDao;
import model.Product;
import model.request.RestRequestUpdateNumber;
import model.response.RestResponseUpdateNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import model.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserDao userDao;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private ProductDao productDao;

    @Override
    public String createUser(User user) {
        var result = userDao.createUser(user);
        if (result > 0){
            return "El usuario ha sido creado correctamente";
        } else {
            return "Ha fallado al crear el usuario";
        }
    }

    @Override
    public String deleteUser(Integer id) {
        try{
            userDao.deleteUser(id);
            return "El usuario ha sido eliminado correctamente";
        } catch (Exception e){
            return "No se pudo eliminar el usuario";
        }
    }

    @Override
    public String updateUser(User user) {
        try{
            userDao.updateUser(user);
            return "El usuario ha sido modificado correctamente";
        }catch (Exception e) {
            return "Ha fallado al modificar el usuario";
        }
    }

    @Override
    public List<User> listUsers() {

        var list = userDao.listUsers();
        return list.stream()
                .sorted(Comparator.comparing(User::getNombre))
                .filter(user -> user.getTelefono() != 0)
                .filter(user -> user.getNombre().startsWith("A") )
                .limit(5)
                .toList();
    }

    @Override
    public User getUserById(Integer id)  {
        try {
            return userDao.getUserById(id);
        } catch (EmptyResultDataAccessException e){
            logger.error("Error en get user id: " + e.getMessage());
        }
        return null;
    }

    @Override
    public RestResponseUpdateNumber changeNumber(RestRequestUpdateNumber restRequestUpdateNumber, Integer id) {
        User updatedUser = userDao.getUserById(id);
        updatedUser.setTelefono(restRequestUpdateNumber.getUpdateNumber());
        userDao.updateUser(updatedUser);
        return RestResponseUpdateNumber.builder()
                .id(updatedUser.getId())
                .nombre(updatedUser.getNombre())
                //.email(updatedUser.getEmail())
                .telefono(updatedUser.getTelefono())
                .build();
    }

    @Override
    public void addReview(Integer id, Integer productId, int calification, String comentario) {
        User user = userDao.getUserById(id);
        Product product = productDao.getProductById(productId);
        userDao.addReview(user.getId(), product.getId(), calification, comentario);
    }
}
