package com.weare.api;


import io.restassured.response.Response;
import testframework.PropertiesManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Requests {


    public static Response registerUser() throws IOException {
        return given()
                .header("Content-Type", "application/json")
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/register-user.json")))
                .post("/api/users/");
    }

    //todo fix below
    public static Response getUserById() throws IOException {
        return given()
                //.header("Cookie", "JSESSIONID=" + sessionCookieValue)
                .baseUri(PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"))
                .body(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/register-user.json")))
                .post("/api/users/");
    }
}
