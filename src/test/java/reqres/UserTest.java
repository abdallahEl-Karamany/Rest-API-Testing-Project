package reqres;

import Models.ResponseModels.GetListUsers;
import Models.ResponseModels.GetSingleUser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static utils.Constants.*;
import static utils.LoginUtils.login;
import static utils.UserUtils.*;

public class UserTest {



    @BeforeClass
    public void loginTest() {
        Response response = login(userName, password);
        JsonPath jsonpath = response.jsonPath();
        token = jsonpath.get("token");

        Assert.assertNotNull(token);
    }

    @Test
    public void testGetSingleUser() {
        SoftAssert softAssert = new SoftAssert();
        int id = 2;
        GetSingleUser response = getSingleUser(id, token,200);
        softAssert.assertEquals(response.data.id, id, "id is not correct");
        softAssert.assertNotNull(response.data.email, "email is Null");
        softAssert.assertNotNull(response.data.firstName, "First Name is Null");
        softAssert.assertNotNull(response.data.lastName, "last Name is Null");
        softAssert.assertNotNull(response.data.avatar, "Avatar is Null");
        softAssert.assertAll();
    }

    @Test
    public void testGetListUsers() {
        SoftAssert softAssert = new SoftAssert();
        GetListUsers response = getListUsers(pageNo,token,200);

        softAssert.assertEquals(response.page, pageNo, "the page number is wrong");
        softAssert.assertEquals(response.perPage, response.data.size(), "the No. of users in the page is wrong");
        for (int i = 0; i < response.data.size(); i++) {
            softAssert.assertNotNull(response.data.get(i).id, "id is not correct");
            softAssert.assertNotNull(response.data.get(i).email, "email is Null");
            softAssert.assertNotNull(response.data.get(i).firstName, "First Name is Null");
            softAssert.assertNotNull(response.data.get(i).lastName, "last Name is Null");
            softAssert.assertNotNull(response.data.get(i).avatar, "Avatar is Null");
        }
        softAssert.assertAll();

    }

    @Test
    public void testCreatUser() {
        Response response = createUser(name, job);
        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(response.statusCode(), 201, "Wrong status code");
        softAssert.assertEquals(jsonPath.getString("name"), "abdallah", "Wrong name at creation");
        softAssert.assertEquals(jsonPath.getString("job"), "student", "Wrong job at creation");
        softAssert.assertNotNull(jsonPath.getString("id"), "the id is null");
        softAssert.assertNotNull(jsonPath.getString("createdAt"), "creation date is null");
        softAssert.assertAll();
    }

    @Test
    public void testCreateUserWithEmptyName() {
        Response response = createUser("", job);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 400, "Wrong status code");
    }

    @Test
    public void testCreateUserWithEmptyJob() {
        Response response = createUser(name, "");
        Assert.assertEquals(response.statusCode(), 400, "Wrong status code");
    }
}
