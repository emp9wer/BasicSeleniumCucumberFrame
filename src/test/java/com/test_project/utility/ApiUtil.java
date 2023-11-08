package com.test_project.utility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ApiUtil {


    public static String getToken(String email,String password){

        return given()
                .contentType(ContentType.JSON)
                .formParam("email" , email)
                .formParam("password" , password)
                .when()
                .post(ConfigurationReader.getProperty("baseUri")+"/users/login")
                .prettyPeek()
                .path("token") ;

    }






}
