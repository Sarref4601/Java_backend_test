package spoonacular;

import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;


public class TestClassifyCuisine extends SpoonacularTest {
    @Test
    void postClassifyCuisineTest() {
        given()
                .param("title", "Pork roast with green beans")
                .param("ingredientList", "3 oz pork shoulder")
                .param("language", "en")
                .expect()
                .when()
                .post("recipes/cuisine")
                .prettyPrint();
    }
}
