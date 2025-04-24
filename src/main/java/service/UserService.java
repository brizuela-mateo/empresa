package service;

import dao.IUserDao;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.User;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

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
        return userDao.listUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
