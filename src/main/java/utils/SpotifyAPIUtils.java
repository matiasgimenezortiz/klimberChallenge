package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpotifyAPIUtils {

    private static final String CLIENT_ID = "b8fa350afdbc439ebd9f439a457532d0";
    private static final String CLIENT_SECRET = "da2593dbf70645de960f9c45a4c5a9b4";

    public static String getAccessToken() {
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", CLIENT_ID)
                .formParam("client_secret", CLIENT_SECRET)
                .when()
                .post("https://accounts.spotify.com/api/token");

        System.out.println(response.getBody().asString());

        return response.jsonPath().getString("access_token");
    }
}
