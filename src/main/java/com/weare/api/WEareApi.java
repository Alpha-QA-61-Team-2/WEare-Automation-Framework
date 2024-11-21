package com.weare.api;

import io.restassured.http.ContentType;
import testframework.PropertiesManager;
import testframework.core.BaseApiService;

import static io.restassured.RestAssured.given;

public class WEareApi extends BaseApiService {

    public WEareApi(String path) {
        super(path, PropertiesManager.getConfigProperties().getProperty("weareBaseUrl"));
    }

    public void authenticate(String username){
        setRequestSpecification(
                given()
                        .contentType(ContentType.JSON)
                        .baseUri(getServiceUrl())
               .cookie("JSESSIONID", PropertiesManager.getConfigProperties().getProperty(String.format("%s.apikey", username)))
        );
    }
}
