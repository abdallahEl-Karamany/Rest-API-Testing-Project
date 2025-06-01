package utils;

import Models.RequestModels.LoginRequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static utils.Constants.*;
import static utils.Headers.generalHeaders;

public class LoginUtils {
    public static Response login(String email, String password,int statusCode ) throws JsonProcessingException {
        LoginRequestModel loginRequestModel = new LoginRequestModel(email, password);

        return RestAssured.given().headers(generalHeaders()).when().body(GeneralUtils.getObject(loginRequestModel)).post(baseURL+loginEndPoint).then()
                .statusCode(statusCode).extract().response();
    }
}
