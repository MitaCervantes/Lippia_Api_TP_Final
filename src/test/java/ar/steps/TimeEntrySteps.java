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

    @Then("se valida que los id de las entradas no sean null")
    public void seValidaQueLosIdDeLasEntradasNoSeanNull() {
        TimeEntryValidator.verifyIdInAllTimesEntries();
    }
}
