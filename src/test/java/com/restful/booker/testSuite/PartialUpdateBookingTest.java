package com.restful.booker.testSuite;

import com.restful.booker.model.PostPojo;
import com.restful.booker.testBase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PartialUpdateBookingTest extends TestBase {

    static String firstname = "Jamess";
    static String lastname = "Brown";
    static int totalprice = 111;
    static Boolean depositpaid = true;
    static String additionalneeds = "Breakfast";


    @Test
    public void partialUpdateBookingsuccessfully() {
        HashMap<String, String> checkInOutDatesData = new HashMap<String, String>();
        checkInOutDatesData.put("checkin", "2018-01-01");
        checkInOutDatesData.put("checkout", "2019-01-01");

        PostPojo postPojo = new PostPojo();
        postPojo.setFirstname(firstname);
        postPojo.setLastname(lastname);
        postPojo.setAdditionalneeds(additionalneeds);

        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .auth().preemptive().basic("admin", "password123")
                        // .header("Accept", "application/json")
                        .pathParam("id", "393")
                        .when()
                        .body(postPojo)
                        .patch("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}