package se.fk.github.rimfrost.arbetsgivare;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.ArbetsgivareControllerApi;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.Anstallning;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.GetArbetsgivare200Response;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.Organisation;

import java.time.LocalDate;
import java.util.ArrayList;

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

      var anstallning = new Anstallning();
      var org = new Organisation();
      org.setNamn("Cool Arbetsgivare AB");
      org.setNummer("123456-7890");

      anstallning.setArbetstid(100);
      anstallning.setOrganisation(org);
      anstallning.setStartdag(LocalDate.now().minusYears(4));
      anstallning.setSlutdag(null);

      response.addAnstallningarItem(anstallning);
      log.info("Arbetsgivare sending response: {}", response);
      return response;
   }
}
