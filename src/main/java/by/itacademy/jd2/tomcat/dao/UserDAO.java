package by.itacademy.jd2.tomcat.dao;

import by.itacademy.jd2.tomcat.model.User;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public enum UserDAO {
    USERS_DATA;

    private Map<String, User> users;

    UserDAO() {
        users = new HashMap<>();
    }


    public User getUserByLogin(String login) {
        User result = null;
        if (users.containsKey(login)) {
            result = users.get(login);
        }
        return result;
    }
    public boolean userIsExist(String login, String password) {

        boolean result = false;
        User user = USERS_DATA.getUserByLogin(login);
        if(nonNull(user)){
            if(user.getPassword().equals(password)){
                result=true;
            }
        }

        return result;
    }

    public void add(User user) {
        if (!users.containsKey(user.getLogin())) {
            users.put(user.getLogin(), user);
        }

    }

}
