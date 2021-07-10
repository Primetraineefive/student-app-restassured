package com.studentapp.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class SearchJsonPathExample {

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


    // 1) Extract limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of limit is: " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract total
    @Test
    public void test002() {

        // Homework

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The search query is: ");
        System.out.println("------------------End of Test---------------------------");

    }

    // 3) Extract first name from data by providing list index value
    @Test
    public void test003() {
        String name = response.extract().path("data[0].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name is: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Get the first list from categories for the first data
    @Test
    public void test004() {
        List<HashMap<String, Object>> categories =  response.extract().path("data[0].categories");

//        categories.stream().forEach(System.out::println);
        for (HashMap<String, Object> category :categories ) {
            System.out.println(category);
        }

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The imageEntities under the first product are: " +categories);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)Print the size of data
    @Test
    public void test005() {
        //Home work

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the items is: ");
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Get All the Names from data
    @Test
    public void test006() {
        // Home work

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are:: ");
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Get the all the values for Name == Duracell - AA Batteries (8-Pack)
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='Duracell - AA Batteries (8-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for item name Straight Talk SAMSUNG Galaxy A20, 32GB Black - Prepaid Smartphone are: " +values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Get the price for Name == Metra - 1/4" DIN Trim Ring for Most Vehicles
    @Test
    public void test008() {
        List<Integer> price = response.extract().path("data.findAll{it.name=='Duracell - D Batteries (4-Pack)'}.price");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The sale price is " +price);
        System.out.println("------------------End of Test---------------------------");
    }

    // 9) Get the Names which have price less than 16.99
    @Test
    public void test009() {
        List<String> names = response.extract().path("data.findAll{it.price<16.99}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of items that price is less than 200 are: " +names);
        System.out.println("------------------End of Test---------------------------");
    }

    // 10) Get the manufacturer of items that Start with name = McV
    @Test
    public void test010() {
        List<String> manufacturer = response.extract().path("data.findAll{it.name==~/McV.*/}.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The msrp of items that start with Str are: " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    // 11) Get the price of items that End with name = Vehicles
    @Test
    public void test011() {

        List<String> price = response.extract().path("data.findAll{it.name==~/.*Vehicles/}.price");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The msrp of items that end with Vehicles are: " +price);
        System.out.println("------------------End of Test---------------------------");
    }

}
