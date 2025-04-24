package dao;

import model.User;

import java.util.List;

public interface IUserDao {
    public List<User> listUsers();
    public User getUserById(Integer id);
    public int createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer id);
}
