package api.gorest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

class GoRestBaseTest {

    protected static RequestSpecification rqSpec;
    protected static ResponseSpecification rsSpec;

    @BeforeAll
    static void setUp() {
        rqSpec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        rsSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }

}
