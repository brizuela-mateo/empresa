package service;

import model.User;

import java.util.List;

public interface IUserService {
    public String createUser(User user);
    public String deleteUser(Integer id);
    public String updateUser(User user);
    public List<User> listUsers();
    public User getUserById(Integer id);
}
