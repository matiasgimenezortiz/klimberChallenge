package asserts;

import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import utils.Screenshots;

public class Validate extends SoftAssert {

	private final Screenshots screen = new Screenshots();
	private final WebDriver d;
	
	public Validate(WebDriver driver) {
		this.d = driver;
	}

	@Override
    public void onAssertFailure(IAssert<?> a, AssertionError ex) {
		screen.takeScreenshot(d);
	}

	public void assertStatusCode(Response response, int expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		assertEquals(actualStatusCode, expectedStatusCode, "Status code mismatch");
	}


	public void assertBodyFieldEquals(Response response, String field, Object expectedValue) {
		Object actualValue = response.jsonPath().get(field);
		assertEquals(actualValue, expectedValue, "Value of field '" + field + "' mismatch");
	}

	public void assertBodyFieldEquals(Response response, String field, boolean expectedValue) {
		boolean actualValue = response.jsonPath().get(field);
		assertEquals(actualValue, expectedValue, "Value of field '" + field + "' mismatch");
	}

	public void assertResponseBodyContains(Response response, String expectedContent) {
		String responseBody = response.getBody().asString();
		assertTrue(responseBody.contains(expectedContent), "Response body does not contain expected content");
	}
}
