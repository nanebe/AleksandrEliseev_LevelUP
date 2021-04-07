package api.simple;

import api.reqres.model.CreateUserRequest;
import api.reqres.model.CreateUserResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RestAssuredSimpleObjectTest {

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

        CreateUserRequest request = new CreateUserRequest("spider-man", "superhero");
        CreateUserResponse expected = CreateUserResponse.builder()
                .name(request.getName())
                .job(request.getJob())
                .build();

        CreateUserResponse res = RestAssured.given(rqSpec)
                .body(request)
                .when()
                .post("/api/users")
                .then()
                .spec(rsSpec)
                .statusCode(201)
                .extract().as(CreateUserResponse.class);

        assertThat(res, equalTo(expected));
    }

}
