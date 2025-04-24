package service;

import model.User;
import model.request.RestRequestUpdateNumber;
import model.response.RestResponseUpdateNumber;

import java.util.List;

public interface IUserService {
    public String createUser(User user);
    public String deleteUser(Integer id);
    public String updateUser(User user);
    public List<User> listUsers();
    public User getUserById(Integer id);

    RestResponseUpdateNumber changeNumber(RestRequestUpdateNumber restRequestUpdateNumber, Integer id);
}
