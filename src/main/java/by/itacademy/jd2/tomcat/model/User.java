package by.itacademy.jd2.tomcat.model;

public class User {
    private int money;

    private String login;

    private String password;

    private ROLE role;

    public User() {
    }

    public User(String login, String password, int money, ROLE role) {
        this.money = money;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public enum ROLE {
        USER, ADMIN, UNKNOWN
    }
}
