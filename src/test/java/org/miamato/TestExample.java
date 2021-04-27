package org.miamato;

import static org.miamato.keywords.PetApi.postPet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.miamato.models.pet.Category;
import org.miamato.models.pet.Pet;
import org.miamato.models.pet.Tag;
import org.testng.annotations.Test;

public class TestExample extends BaseTest {



    @Test
    public void tryHard(){
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

        postPet(pet);

    }

}
