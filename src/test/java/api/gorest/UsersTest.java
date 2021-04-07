package api.gorest;

import api.gorest.model.users.UsersResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class UsersTest extends GoRestBaseTest {

    @Test
    void getAllUsersTest() {
        given(rqSpec)
                .when()
                .get("/public-api/users")
                .then()
                .spec(rsSpec)
                .statusCode(200)
                .extract().as(UsersResponse.class);
    }

}
