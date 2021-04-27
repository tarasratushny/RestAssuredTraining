package org.miamato;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.miamato.keywords.KeywordManager;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected KeywordManager keywordManager;

    @BeforeClass
    public void setup(){

        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2/")
            .setAccept("application/json")
            .setContentType("application/json")
            .build();

        keywordManager = new KeywordManager();
    }

}
