package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetAlbumTest extends SpotifyBaseTest {

    @Test
    public void testGetAlbum() {
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/albums/4aawyAB9vmqN3uQ7FjRGTy");

        System.out.println(response.getBody().asString());

        response.then().statusCode(200);
    }
}
