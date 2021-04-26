package org.miamato.keywords;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import org.miamato.models.pet.Pet;

public class PetApi {

    public static void postPet(Pet pet){

        Response response = given().body(pet)
            .when().post("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();

        response.then().statusCode(200);
    }

}
