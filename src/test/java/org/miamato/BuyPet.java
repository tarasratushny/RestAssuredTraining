package org.miamato;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.miamato.context.Context;
import org.miamato.models.order.Order;
import org.miamato.models.pet.Category;
import org.miamato.models.pet.Pet;
import org.miamato.models.pet.Tag;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuyPet extends BaseTest {

    private static final Logger log = LogManager.getLogger(BuyPet.class.getSimpleName());
    private Pet pet;

    @DataProvider
    public Object[][] pets(){
        return new Object[][]{
            {new Pet()
                .withId(10)
                .withName("Aramis")
                .withStatus("Alive")
                .withCategory(new Category(12, "Dogs"))
                .withTag(new Tag(20, "Snoring"))
                .withPhotoUrl("imagine.this.is.url")
            }
        };
    }



    @Test(dataProvider = "pets")
    public void createOrderForPet(Pet pet){

        keywordManager.petApi().postPet(pet)
            .storeApi().postOrder(pet.getId(), 5);

        checkPostOrderResponse(pet, 5);
    }


    @Step
    private void checkPostOrderResponse(Pet pet, int quantity){
        log.info("Checking response for POST order call \n");
        Order expectedResult = new Order()
            .withId(Context.getInstance().getId("OrderId"))
            .withPetId(pet.getId())
            .withComplete(true)
            .withStatus("placed")
            .withShipDate(Context.getInstance().getDate("ShipDate").toString() + "+0000")
            .withQuantity(quantity);

        Assert.assertEquals(Context.getInstance().getResponse("CreateOrder").as(Order.class),
            expectedResult);

    }

}
