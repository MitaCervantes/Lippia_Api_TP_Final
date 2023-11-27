package ar.steps;

import ar.validator.TimeEntryValidator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;
import services.BaseService;

public class TimeEntrySteps {
    Dotenv dotenv = Dotenv.configure().directory("src/main/resources/env").load();

    @And("I enter the userId")
    public void enterTheUserId() {
        BaseService.AddParams("user_id", dotenv.get("USER_ID"));
    }

    @Then("validate that the ids are not null")
    public void validateIdNotNull() {
        TimeEntryValidator.verifyIdInTimesEntries();
    }
    @And("I enter data in body")
    public void enterDataBody() {
        TimeEntryValidator.dataBodyTimeEntry();
    }

    @Then("the correct data is validated in time entry")
    public void correctDataValidatedInTimeEntry() {
        TimeEntryValidator.verifyDataTimeEntry();
    }

    @Then("I get a response object with two properties")
    public void responseObjectWithProperties() {
        TimeEntryValidator.verifyErrorResponse();
    }

    @And("I check if there is a time entry created")
    public void checkTimeEntryCreated() {
        TimeEntryValidator.verifyTimeEntryCreated();
    }

    @And("modify data of a time entry")
    public void modifyTimeEntryData() {
        TimeEntryValidator.getIdTimeEntry();
        TimeEntryValidator.dataBodyUpdate();
    }
}
