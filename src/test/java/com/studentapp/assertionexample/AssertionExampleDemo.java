package com.studentapp.assertionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Created by Jay
 */
public class AssertionExampleDemo {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then();
    }

    // 1) Verify if the products of limit is equal to 10
    @Test
    public void test001() {
        response.body("limit", equalTo(10));
    }

    // 2) Verify total = 51962
    @Test
    public void test002() {
        // Home work

    }

    // 3) Check Single Name in ArrayList (Duracell - AA Batteries (8-Pack))
    @Test
    public void test003() {
        response.body("data.name", hasItem("Duracell - AA Batteries (8-Pack)"));

    }

    // 4) Check Multiple Names in ArrayList (Metra - 1/4" DIN Trim Ring for Most Vehicles ,
    // Metra - Turbowire Radio Harness Adapter for Select Jeep Vehicles )
    @Test
    public void test004() {
        // HOME WORK

    }

    // 5) Verify the name inside first categories for the first data (Checking Values inside Map using hasKey(entityType))
    @Test
    public void test005() {
        response.body("data[0].categories[0]", hasKey("name"));

    }

    // 6) Check hash map values inside "name": "McVities Biscuits18836", "a manufacturer = Duracell
    @Test
    public void test006() {
        response.body("data.findAll{it.name=='McVities Biscuits18836'}", hasItems(hasEntry("manufacturer", "Duracell")));

    }

    // 7) Checking multiple values in the same statement
    @Test
    public void test007() {
        response.body("limit", equalTo(10))
                .body("data.name", hasItem("Duracell - AA Batteries (8-Pack)"))
                .body("data.findAll{it.name=='McVities Biscuits18836'}", hasItems(hasEntry("manufacturer", "Duracell")));

    }

    // 8) Logical Assertions
    @Test
    public void test008() {
        response.body("data.size()", equalTo(10))
                .body("data.size()",lessThan(12))
                .body("data.size()",greaterThan(9))
                .body("data.size()",lessThanOrEqualTo(10));
    }
}
