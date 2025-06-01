package reqres;

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
        Response response = login(email, password,200);
        JsonPath jsonpath = response.jsonPath();
        jsonpath.prettyPrint();
        Assert.assertNotNull(jsonpath.get("token"), "the Token is Null");
    }

    @Test
    public void testLoginWithInvalidEmail() throws JsonProcessingException {
        Response response = login(email + "aaa", password,400);
        response.prettyPrint();
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 400, "Wrong Status code");
        Assert.assertEquals(jsonpath.getString("error"), "user not found", "the user found ");
    }

    @Test
    public void testLoginWithEmptyEmail() throws JsonProcessingException {
        Response response = login("", password,400);
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 400, "Wrong Status code");
        Assert.assertEquals(jsonpath.getString("error"), "Missing email or username", "the user found ");
    }

    @Test
    public void testLoginWithEmptyPassword() throws JsonProcessingException {
        Response response = login(email, "",400);
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(jsonpath.getString("error"), "Missing password", "the user logged with empty password ");
    }

    @Test
    public void testLoginWithInvalidPassword() throws JsonProcessingException {
        Response response = login(email, "aavffdd",401);
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(jsonpath.getString("error"), "Wrong password", "the user logged with empty password ");
    }
}
