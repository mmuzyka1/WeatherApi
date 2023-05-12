import enums.Cities;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static io.restassured.RestAssured.given;

public class CurrentWeatherTest extends TestApiBase {

    @ParameterizedTest
    @EnumSource(value = Cities.class)
    @Tag("weather")
    void shouldValidateCityByCityId(Cities city) {
        given().
                spec(getRequestSpecification(city)).
        when().
                get().
        then().
                spec(getResponseSpecification(city)).extract().response().prettyPrint();
    }
}
