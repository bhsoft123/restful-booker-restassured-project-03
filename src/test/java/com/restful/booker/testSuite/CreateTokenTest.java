package com.restful.booker.testSuite;

import com.restful.booker.model.UserPojo;
import com.restful.booker.testBase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateTokenTest extends TestBase {

    static String username = "admin";
    static String password = "password123";


    @Test
    public void createTokenTest(){
        UserPojo userPojo = new UserPojo();
        userPojo.setUsername(username);
        userPojo.setPassword(password);

        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .body(userPojo)
                .post("/auth");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
