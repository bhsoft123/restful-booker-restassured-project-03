package com.restful.booker.testSuite;

import com.restful.booker.model.PostPojo;
import com.restful.booker.testBase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends TestBase {

    static String firstname = "James";
    static String lastname = "Brown";
    static int totalprice = 111;
    static Boolean depositpaid = true;
    static String additionalneeds = "Breakfast";


    @Test
    public void createABookingsuccessfully() {
        HashMap<String,String> checkInOutDatesData = new HashMap<String,String>();
        checkInOutDatesData.put("checkin","2018-01-01");
        checkInOutDatesData.put("checkout","2019-01-01");

        PostPojo postPojo = new PostPojo();
        postPojo.setFirstname(firstname);
        postPojo.setLastname(lastname);
        postPojo.setTotalprice(totalprice);
        postPojo.setDepositpaid(depositpaid);
        postPojo.setAdditionalneeds(additionalneeds);
        postPojo.setBookingdates(checkInOutDatesData);

        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .auth().preemptive().basic("admin", "password123")
                        .header("Accept", "application/json")
                        .body(postPojo)
                        .when()
                        .put("/booking/2159");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    }

