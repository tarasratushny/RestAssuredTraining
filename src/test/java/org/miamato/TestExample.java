package org.miamato;

import static io.restassured.RestAssured.*;
import static org.miamato.keywords.PetApi.postPet;

import io.restassured.response.Response;
import java.util.Collections;
import org.miamato.models.pet.Category;
import org.miamato.models.pet.Pet;
import org.testng.annotations.Test;

public class TestExample extends BaseTest {

    @Test
    public void tryRestAssured(){

        Response response = when().get("https://petstore.swagger.io/v2/pet/2");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void tryHard(){
        Pet pet = new Pet();
        pet.id=10;
        pet.category = new Category();
        pet.category.id=123;
        pet.category.name="Cats";
        pet.name="Kitsune";
        pet.photoUrls= Collections.singletonList("someUrl");
        pet.status="dead";
        postPet(pet);
    }

}
