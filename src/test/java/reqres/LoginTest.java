package reqres;

import Models.ResponseModels.InvalidLoginResponseModel;
import Models.ResponseModels.LoginResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.Constants.email;
import static utils.Constants.password;
import static utils.LoginUtils.login;

public class LoginTest {


    @Test
    public void testSuccessfulLogin() throws JsonProcessingException {
        LoginResponseModel response = login(email, password,200, LoginResponseModel.class);

        Assert.assertNotNull(response.token, "the Token is Null");
    }

    @Test
    public void testLoginWithInvalidEmail() throws JsonProcessingException {
        InvalidLoginResponseModel response = login(email + "aaa", password,400,InvalidLoginResponseModel.class);

        Assert.assertEquals(response.error, "user not found", "the user found ");
    }

    @Test
    public void testLoginWithEmptyEmail() throws JsonProcessingException {
        InvalidLoginResponseModel response = login("", password,400,InvalidLoginResponseModel.class);

        Assert.assertEquals(response.error, "Missing email or username", "the user found ");
    }

    @Test
    public void testLoginWithEmptyPassword() throws JsonProcessingException {
        InvalidLoginResponseModel response = login(email, "",400,InvalidLoginResponseModel.class);

        Assert.assertEquals(response.error, "Missing password", "the user logged with empty password ");
    }

    @Test
    public void testLoginWithInvalidPassword() throws JsonProcessingException {
        InvalidLoginResponseModel response = login(email, "aavffdd",401,InvalidLoginResponseModel.class);

        Assert.assertEquals(response.error, "Wrong password", "the user logged with empty password ");
    }
}
