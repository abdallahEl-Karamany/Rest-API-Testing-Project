package utils;

import Models.RequestModels.CreateUserRequestModel;
import Models.ResponseModels.GetListUsers;
import Models.ResponseModels.GetSingleUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static utils.Constants.*;
import static utils.Constants.userEndPoint;
import static utils.Headers.generalHeaders;

public class UserUtils {
    public static <T>T getSingleUser(int id, String token, int statusCode,Class<T> responseClass){

        return RestAssured.given().headers(generalHeaders(token)).get(baseURL+userEndPoint+"/"+id).then().statusCode(statusCode).extract()
                .response().as(responseClass);
    }
    public static GetListUsers getListUsers(int pageNo, String token,int statusCode){
        Map<String,Integer> queryParam=new HashMap<>();
        queryParam.put("page",pageNo);
        return RestAssured.given().headers(generalHeaders(token)).queryParams(queryParam).when().get(baseURL+userEndPoint)
                .then().statusCode(statusCode).extract().response().as(GetListUsers.class);
    }
    public static Response createUser(String Name ,String job,int statusCode) throws JsonProcessingException {
        CreateUserRequestModel createUser=new CreateUserRequestModel(Name,job);
        return  RestAssured.given().headers(generalHeaders()).when().body(GeneralUtils.getObject(createUser)).post(baseURL+userEndPoint).then().statusCode(statusCode).extract().response();
    }
}
