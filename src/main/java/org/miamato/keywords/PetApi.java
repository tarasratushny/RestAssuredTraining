package org.miamato.keywords;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.response.Response;
import java.util.HashMap;
import org.miamato.models.pet.Pet;

public class PetApi {

    public static void postPet(Pet pet){

        Response response = given().body(pet)
            .when().post("/pet");

        response.prettyPrint();

        response.then().statusCode(200);

    }

    public static void getPet(int id) {

        Response response = when().get("/pet/" + id);

        response.prettyPrint();

        response.then().statusCode(200);
    }

    public static void getPetByStatus(String status){

        Response response = given().queryParams("status", status)
            .when().get("/pet/findByStatus");

        response.prettyPrint();

        response.then().statusCode(200);

    }

    public static void postPetUpdateNameAndStatus(int id, String newName, String newStatus) {

        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("name", newName);
        formParams.put("status", newStatus );

        Response response = given().formParams( formParams )
            .contentType("application/x-www-form-urlencoded")
            .when().post("/pet/" + id);

        response.prettyPrint();

        response.then().statusCode(200);

    }

}
