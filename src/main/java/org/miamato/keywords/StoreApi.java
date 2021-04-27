package org.miamato.keywords;

import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.time.ZoneId;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.miamato.context.Context;
import org.miamato.context.IdGenerator;
import org.miamato.models.order.Order;
import org.miamato.utils.PrintUtils;

public class StoreApi {

    private static final Logger log = LogManager.getLogger(StoreApi.class.getSimpleName());
    private KeywordManager keywordManager;
    private static final String CREATE_ORDER_PATH = "/store/order";

    public StoreApi(KeywordManager keywordManager) {
        this.keywordManager = keywordManager;
    }
    @Step
    public KeywordManager postOrder(int petId, int quantity) {

        log.info(
            "POST ORDER -- DATA -- Creating order for pet with id: " + petId + " and quantity: "
                + quantity + "\n");

        Context.getInstance()
            .addId("OrderId", IdGenerator.generateId())
            .addDate("ShipDate", new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());


        Order orderBody = new Order()
            .withId(Context.getInstance().getId("OrderId"))
            .withPetId(petId)
            .withQuantity(quantity)
            .withStatus("placed")
            .withShipDate(Context.getInstance().getDate("ShipDate").toString())
            .withComplete(true);

        log.info(
            "POST ORDER -- DATA -- Request body: \n " + PrintUtils.prettyPrintPojo(orderBody));

        Response response = given().body(orderBody)
            .when().post(CREATE_ORDER_PATH);

        log.info("POST ORDER -- RESPONSE -- Body received: \n" + response.asPrettyString() + "\n");
        log.info("POST ORDER -- RESPONSE CODE: " + response.statusCode() + "\n");

        Context.getInstance().addResponse("CreateOrder", response);

        response.then().statusCode(200);

        return keywordManager;
    }
}
