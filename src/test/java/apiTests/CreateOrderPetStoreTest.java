package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testrunner.PetStoreBaseTest;

import static io.restassured.RestAssured.given;

public class CreateOrderPetStoreTest extends PetStoreBaseTest {
    @Test
    public void testCreateOrder() {
        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2024-03-26T23:44:45.050Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/store/order")
                .then()
                .extract().response();

        validator.assertStatusCode(response, 200);
        validator.assertBodyFieldEquals(response, "status", "placed");
        validator.assertBodyFieldEquals(response, "complete", true);

    }
}
