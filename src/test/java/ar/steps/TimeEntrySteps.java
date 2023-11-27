package ar.steps;

import ar.validator.TimeEntryValidator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;
import services.BaseService;

public class TimeEntrySteps {
    Dotenv dotenv = Dotenv.configure().directory("src/main/resources/env").load();

    @And("ingreso el userId para consultar")
    public void ingresoElUserIdAConsultar() {
        BaseService.AddParams("user_id", dotenv.get("USER_ID"));
    }

    @Then("se valida que los id no sean null")
    public void seValidaQueLosIdNoSeanNull() {
        TimeEntryValidator.verifyIdInTimesEntries();
    }
    @And("ingreso datos en body")
    public void ingresoDatosEnBody() {
        TimeEntryValidator.dataBodyTimeEntry();
    }

    @Then("se valida datos correctos en time entry")
    public void seValidaDatosCorrectosEnTimeEntry() {
        TimeEntryValidator.verifyDataTimeEntry();
    }


    @Then("se obtiene un objeto response con dos propiedades")
    public void seObtieneUnObjetoResponseConDosPropiedades() {
        TimeEntryValidator.verifyResponse();
    }
}
