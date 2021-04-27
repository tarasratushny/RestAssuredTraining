package org.miamato;


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
    public void createPetWithBuilder() {

        Pet pet = new Pet()
            .withId(10)
            .withName("Aramis")
            .withStatus("Alive")
            .withCategory(new Category(12, "Dogs"))
            .withTag(new Tag(20, "Snoring"))
            .withPhotoUrl("imagine.this.is.url");

        keywordManager.petApi().postPet(pet)
            .petApi().getPet(pet.getId())
            .petApi().getPetsByStatus(pet.getStatus())
            .petApi().postPetUpdateNameAndStatus(10, "Jango", "Free")
            .petApi().getPetsByStatus("Free");

        checkPetName("Aramis");

    }

    private static void checkPetName(String expectedName) {

        log.info("Checking first pet name in get pets by status call \n");
        Assert.assertEquals(
            Context.getInstance().getResponse("GetPetsByStatus").then().extract().path("[0].name"),
            expectedName);

    }

}
