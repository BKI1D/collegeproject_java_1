package sample;

public class User {
    private String Login;
    private String Password;
    private String Email;
    private int AccessCode;

    public User(String login, String password, String email, int accessCode) {
        Login = login;
        Password = password;
        Email = email;
        AccessCode = accessCode;
    }

    public User() {

    }

    //Set
    public void setLogin(String login) {
        Login = login;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setAccessCode(int accessCode) {
        AccessCode = accessCode;
    }
    //Get
    public String getLogin() {
        return Login;
    }
    public String getPassword() {
        return Password;
    }
    public String getEmail() {
        return Email;
    }
    public int getAccessCode() {
        return AccessCode;
    }
}
