package com.weare.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testframework.PropertiesManager;
import testframework.core.BaseApiService;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class WEareApi extends BaseApiService {

    public WEareApi(String path) {
        super(path, PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"));
    }

    public static String getCookie() {
        Response loginResponse = given()
                .baseUri(baseURI)
                .formParam("username", "milko")
                .formParam("password", "111111")
                .post("/authenticate");

        return loginResponse.then()
                .statusCode(302) // Assert the status code is 200
                .extract()
                .cookie("JSESSIONID");
    }
}
