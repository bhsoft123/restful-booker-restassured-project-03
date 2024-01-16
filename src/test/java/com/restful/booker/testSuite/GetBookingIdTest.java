package com.restful.booker.testSuite;

import com.restful.booker.testBase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookingIdTest extends TestBase {

    @Test
    public void verifyBookingId(){

        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
