package utils;

import Models.ResponseModels.GetListUsers;
import Models.ResponseModels.GetSingleUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static utils.Constants.*;
import static utils.Constants.userEndPoint;
import static utils.Headers.generalHeaders;

public class UserUtils {
    public static GetSingleUser getSingleUser(int id, String token, int statusCode){

        return RestAssured.given().headers(generalHeaders(token)).get(baseURL+userEndPoint+"/"+id).then().statusCode(statusCode).extract()
                .response().as(GetSingleUser.class);
    }
    public static GetListUsers getListUsers(int pageNo, String token,int statusCode){
        Map<String,Integer> queryParam=new HashMap<>();
        queryParam.put("page",pageNo);
        return RestAssured.given().headers(generalHeaders(token)).queryParams(queryParam).when().get(baseURL+userEndPoint)
                .then().statusCode(statusCode).extract().response().as(GetListUsers.class);
    }
    public static Response createUser(String Name ,String job){
        return  RestAssured.given().headers(generalHeaders()).body("{\n" +
                "    \"name\": \""+Name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}").when().post(baseURL+userEndPoint).then().extract().response();
    }
}
