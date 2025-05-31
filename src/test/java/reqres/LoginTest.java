package reqres;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.Constants.email;
import static utils.Constants.password;
import static utils.LoginUtils.login;

public class LoginTest {


    @Test
    public void testSuccessfulLogin() {
        Response response = login(email, password);
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 200, "Wrong Status code");
        Assert.assertNotNull(jsonpath.get("token"), "the Token is Null");
    }

    @Test
    public void testLoginWithInvalidEmail() {
        Response response = login(email + "aaa", password);
        response.prettyPrint();
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 400, "Wrong Status code");
        Assert.assertEquals(jsonpath.getString("error"), "user not found", "the user found ");
    }

    @Test
    public void testLoginWithEmptyEmail() {
        Response response = login("", password);
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 400, "Wrong Status code");
        Assert.assertEquals(jsonpath.getString("error"), "Missing email or username", "the user found ");
    }

    @Test
    public void testLoginWithEmptyPassword() {
        Response response = login(email, "");
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 400, "Wrong Status code");
        Assert.assertEquals(jsonpath.getString("error"), "Missing password", "the user logged with empty password ");
    }

    @Test
    public void testLoginWithInvalidPassword() {
        Response response = login(email, password + "aa");
        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 401, "Wrong Status code");
        Assert.assertEquals(jsonpath.getString("error"), "Wrong password", "the user logged with empty password ");
    }
}
