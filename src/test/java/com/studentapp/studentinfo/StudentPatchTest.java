package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("prime21@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .patch("/101");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
