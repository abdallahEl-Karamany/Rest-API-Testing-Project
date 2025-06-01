package Models.RequestModels;

public class CreateUserRequestModel {
    public CreateUserRequestModel(String name, String job) {
        this.name = name;
        this.job = job;
    }
    public String name;
    public String job;
}
