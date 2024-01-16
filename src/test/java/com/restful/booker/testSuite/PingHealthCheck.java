package com.restful.booker.testSuite;

import com.restful.booker.testBase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PingHealthCheck extends TestBase {

    @Test
    public void healthCheck() {
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .header("Accept", "*/*")
                        .when()
                        .get("/ping");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
