package testrunner;

import asserts.Validate;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class PetStoreBaseTest {

    protected Validate validator = new Validate(null);

    @BeforeClass
    public void setup() {
        // Set base URI
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}
