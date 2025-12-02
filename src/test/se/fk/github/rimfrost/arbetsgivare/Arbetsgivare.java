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
            {
  "anstallningar": [
    {
      "arbetstid": 100,
      "organisation": {
        "namn": "Cool Arbetsgivare AB",
        "nummer": "123456-7890"
      },
      "startdag": "2021-12-02",
      "slutdag": null
    }
  ]
}
            """);
   }
}
