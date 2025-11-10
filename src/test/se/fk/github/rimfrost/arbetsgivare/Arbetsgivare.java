package se.fk.github.rimfrost.arbetsgivare;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class ArbetsgivareTest
{

   @Test
   void testArbetsgivareTrue()
   {
      String actualResponse = given()
            .when().get("/arbetsgivare/1234")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      assertThat(actualResponse).isEqualToIgnoringWhitespace("""
            {"result":true}
            """);
   }

   @ParameterizedTest
   @ValueSource(strings =
   {
         "19999", "15429"
   })
   void testArbetsgivareFalse(String personnummer)
   {
      String actualResponse = given()
            .when().get("/arbetsgivare/" + personnummer)
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      assertThat(actualResponse).isEqualToIgnoringWhitespace("""
            {"result":false}
            """);
   }

}
