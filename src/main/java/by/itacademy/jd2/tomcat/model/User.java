package by.itacademy.jd2.tomcat.model;

public class User {
    private int cash;

    private String login;

    private String password;

    private ROLE role;

    public User() {
    }

    public User(String login, String password,int cash, ROLE role) {
        this.cash = cash;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
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
