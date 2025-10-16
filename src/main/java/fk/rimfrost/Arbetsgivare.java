package fk.rimfrost;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.ArbetsgivareControllerApi;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.GetArbetsgivare200Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST controller that handles requests for the Arbetsgivare API.
 */
@SuppressWarnings("SpellCheckingInspection")
@ApplicationScoped
@Path("/arbetsgivare/{personnummer}")
public class Arbetsgivare implements ArbetsgivareControllerApi
{
   private static final Logger log = LoggerFactory.getLogger(Arbetsgivare.class);

   /**
    * Default constructor for ApplicationScoped resource.
    */
   public Arbetsgivare()
   {
      // Default constructor required to suppress warning
   }

   public GetArbetsgivare200Response getArbetsgivare(String personnummer)
   {
      log.info("Arbetsgivare received request: personnummer={}", personnummer);
      var response = new GetArbetsgivare200Response();
      String lastFour = personnummer.substring(personnummer.length() - 4);
      boolean isInvalid = lastFour.equals("9999") || lastFour.equals("9002");
      response.setResult(!isInvalid);
      log.info("Arbetsgivare sending response: {}", response);
      return response;
   }
}
