package org.miamato;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.miamato.context.Context;
import org.miamato.models.pet.Category;
import org.miamato.models.pet.Pet;
import org.miamato.models.pet.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample extends BaseTest {

    private static final Logger log = LogManager.getLogger(TestExample.class.getSimpleName());

    @Test
    public void createPet(){
        Tag tag = new Tag();
        tag.id=0;
        tag.name="ForSale";

        Pet pet = new Pet();
        pet.id=10;
        pet.category = new Category();
        pet.category.id=123;
        pet.category.name="Cats";
        pet.name="Kitsune";
        pet.photoUrls= Collections.singletonList("someUrl");
        pet.status="dead";
        pet.tags = new ArrayList<>();
        pet.tags.add(tag);

        keywordManager.petApi().postPet(pet);

    }

    @Test
    public void createPetWithBuilder(){

        Pet pet = new Pet()
            .withId(10)
            .withName("Aramis")
            .withStatus("Alive")
            .withCategory(new Category(12, "Dogs"))
            .withTag(new Tag(20, "Snoring"))
            .withPhotoUrl("imagine.this.is.url");

        keywordManager.petApi().postPet(pet)
            .petApi().getPet(pet.id)
            .petApi().getPetsByStatus(pet.status)
            .petApi().postPetUpdateNameAndStatus(10, "Jango", "Free")
            .petApi().getPetsByStatus("Free");

        checkPetName("Aramis");

    }

    private static void checkPetName(String expectedName){

        log.info("Checking first pet name in get pets by status call \n");
        Assert.assertEquals(Context.getInstance().getResponse("GetPetsByStatus").then().extract().path("[0].name"), expectedName);

    }

}
