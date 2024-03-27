package apiTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import utils.SpotifyAPIUtils;

public class SpotifyBaseTest {
    protected String accessToken;
    protected String userId;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://api.spotify.com/v1";
        accessToken = SpotifyAPIUtils.getAccessToken();

        userId = "11168023703";
    }
}
