package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static utils.Constants.baseURL;
import static utils.Constants.loginEndPoint;
import static utils.Headers.generalHeaders;

public class LoginUtils {
    public static Response login(String email, String password ){
        return RestAssured.given().headers(generalHeaders()).when().body("{\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}").post(baseURL+loginEndPoint).then().extract().response();
    }
}
