package org.miamato;

import static io.restassured.RestAssured.when;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SiplestTestExample {


    @Test
    public void tryRestAssured(){

        Response response = when().get("https://petstore.swagger.io/v2/pet/10");
        response.prettyPrint();
        response.then().statusCode(200);

    }


}
