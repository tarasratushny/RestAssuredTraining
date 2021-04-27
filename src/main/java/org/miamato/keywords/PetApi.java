package org.miamato.keywords;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.miamato.context.Context;
import org.miamato.models.pet.Pet;
import org.miamato.utils.PrintUtils;

public class PetApi {

    private static final Logger log = LogManager.getLogger(PetApi.class.getSimpleName());

    private KeywordManager keywordManager;

    private static final String CREATE_PET_PATH = "/pet";
    private static final String GET_PET_PATH = "/pet/{petId}";
    private static final String GET_PET_BY_STATUS_PATH = "/pet/findByStatus";
    private static final String UPDATE_PET_NAME_AND_STATUS_PATH = "/pet/{petId}";

    public PetApi(KeywordManager keywordManager) {
        this.keywordManager = keywordManager;
    }

    public KeywordManager postPet(Pet pet){

        log.info("POST PET -- DATA -- Creating pet with data: \n " + PrintUtils.prettyPrintPojo(pet) + "\n");

        Response response = given().body(pet)
            .when().post(CREATE_PET_PATH);

        log.info("POST PET -- RESPONSE -- Body received: \n" + response.asPrettyString() + "\n");
        log.info("POST PET -- RESPONSE CODE: " + response.statusCode() + "\n");

        Context.getInstance().addResponse("CreatePet", response);

        response.then().statusCode(200);

        return keywordManager;
    }

    public KeywordManager getPet(int id) {

        log.info("GET PET -- DATA -- Getting information about pet with id: " + id + "\n");


        Response response = given().pathParam("petId", id)
            .when().get(GET_PET_PATH);

        log.info("GET PET -- RESPONSE -- Body received: \n" + response.asPrettyString() + "\n");
        log.info("GET PET -- RESPONSE CODE: " + response.statusCode() + "\n");

        Context.getInstance().addResponse("GetPetById", response);

        response.then().statusCode(200);

        return keywordManager;
    }

    public KeywordManager getPetsByStatus(String status){

        log.info("GET PETS -- DATA -- Getting pets list with status: " + status + "\n");

        Response response = given().queryParams("status", status)
            .when().get(GET_PET_BY_STATUS_PATH);

        log.info("GET PETS -- RESPONSE -- Body received: \n" + response.asPrettyString() + "\n");
        log.info("GET PETS -- RESPONSE CODE: " + response.statusCode() + "\n");

        Context.getInstance().addResponse("GetPetsByStatus", response);

        response.then().statusCode(200);

        return keywordManager;
    }

    public KeywordManager postPetUpdateNameAndStatus(int id, String newName, String newStatus) {

        log.info("POST PET -- DATA -- Updating pet with id: " + id + " New name: " + newName + " New Status: " + newStatus  + "\n");

        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("name", newName);
        formParams.put("status", newStatus );

        Response response = given().formParams( formParams )
            .contentType("application/x-www-form-urlencoded")
            .pathParam("petId", id)
            .when().post(UPDATE_PET_NAME_AND_STATUS_PATH);

        log.info("POST PET -- RESPONSE -- Body received: \n" + response.asPrettyString() + "\n");
        log.info("POST PET -- RESPONSE CODE: " + response.statusCode() + "\n");

        Context.getInstance().addResponse("UpdatePetNameAndStatus", response);

        response.then().statusCode(200);

        return keywordManager;
    }

}
