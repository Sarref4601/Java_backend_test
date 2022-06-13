package spoonacular;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RecipesTest extends SpoonacularTest {

        @Test
        void testTasteById() {
            given()
                    .pathParam("id", 520)
                    .expect()
                    .body("sweetness", is(18.65F))
                    .body("saltiness", is(100.0F))
                    .body("sourness", is(13.4F))
                    .body("bitterness", is(13.35F))
                    .body("savoriness", is(23.42F))
                    .body("fattiness", is(97.25F))
                    .body("spiciness", is(0.0F))
                    .when()
                    .get("recipes/{id}/tasteWidget.json");
        }

        @Test
        void testSummaryRecipe() throws IOException {
            given()
                    .pathParam("id", 4632)
                    .expect()
                    .body("id",is(4632))
                    .body("title", is("Soy-and-Ginger-Glazed Salmon with Udon Noodles"))
                    .when()
                    .get("recipes/{id}/summary")
                    .body()
                    .prettyPrint();
        }


        @Disabled
        @Test
    void getSimilarRecipeTest() throws IOException {
        String actually = given()
                .pathParam("id", 715538)
                .expect()
                .when()
                .get("recipes/{id}/similar")
                .body()
                .prettyPrint();

        String expected = getResource("expected.json");
        assertJson(expected, actually);
        }
}