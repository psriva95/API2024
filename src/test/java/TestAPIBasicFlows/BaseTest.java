package TestAPIBasicFlows;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BaseTest {

    @Test
    public void testGetResponseStatusCode(){
        given()
                .baseUri("https://api.postman.com")
                .header("x-api-key","").
        when()
                .get("/workspaces").
        then()
                .log().all().
                assertThat().
                statusCode(200);
    }

    @Test
    public void testGetResponseBody(){
        given()
                .baseUri("https://api.postman.com")
                .header("x-api-key","").
                when()
                .get("/workspaces").
                then()
                .log().all().
                assertThat().
                statusCode(200)
                .body("workspaces.name",hasItems("My Workspace"));
    }

}
