package Models.RequestModels;

public class LoginRequestModel {
    public LoginRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String email;
    public String password;
}
