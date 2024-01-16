package com.restful.booker.testSuite;

import com.restful.booker.testBase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleIDTest extends TestBase {

    @Test
    public void getSingleIDTest(){
        Response response = given()
                .pathParam("id","2467")
                .when()
                .get("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
