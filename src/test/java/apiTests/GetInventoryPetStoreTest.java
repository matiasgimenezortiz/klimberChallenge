package apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import testrunner.PetStoreBaseTest;

import static io.restassured.RestAssured.given;

public class GetInventoryPetStoreTest extends PetStoreBaseTest {

    @Test
    public void testGetInventory() {

        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("/store/inventory")
                .then()
                .log().all()
                .extract().response();

        validator.assertStatusCode(response, 200);
    }
}
