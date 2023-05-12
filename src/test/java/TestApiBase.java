import enums.Cities;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApiBase {

    public static RequestSpecification getRequestSpecification(Cities city) {
        return given()
                .baseUri("https://api.openweathermap.org/data/2.5/weather")
                .header("expRespTime", 5000)
                .param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .param("q", city.getCityName() + city.getCountry())
                .log()
                .all();
    }

    public static ResponseSpecification getResponseSpecification(Cities city) {
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200);
        responseSpecification.body("name", equalTo(city.getCityName()));
        responseSpecification.log().all();
        return responseSpecification;
    }
}