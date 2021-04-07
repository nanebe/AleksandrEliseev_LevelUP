package api.simple;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

class RestAssuredSimpleTest {

    RequestSpecification rqSpec;
    ResponseSpecification rsSpec;

    @BeforeEach
    void setUp() {
        rqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        rsSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }


    @Test
    void restAssuredSimpleTest() {
        RestAssured.given()
                .baseUri("https://reqres.in/")
                .header(new Header("Content-Type", "application/json"))
                .body("{\n" +
                        "    \"name\": \"spider-man\",\n" +
                        "    \"job\": \"superhero\"\n" +
                        "}")
                .log().all()
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("name", equalTo("spider-man"))
                .body("job", equalTo("superhero"))
                .body("id", not(emptyString()))
                .body("createdAt", not(emptyString()));
    }

    @Test
    void restAssuredRequestTest() {
        RestAssured
                .given(rqSpec)
                .when()
                .get("/api/users")
                .then()
                .spec(rsSpec)
                .statusCode(200);
    }

}
