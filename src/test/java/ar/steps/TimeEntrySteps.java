package ar.steps;

import ar.validator.TimeEntryValidator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.Test;
import services.BaseService;

public class TimeEntrySteps {
    Dotenv dotenv = Dotenv.configure().directory("src/main/resources/env").load();
    @Test(priority=1)
    @And("I enter the userId")
    public void enterTheUserId() {
        BaseService.AddParams("user_id", dotenv.get("USER_ID"));
    }
    @Test(priority=2)
    @And("I enter data in body")
    public void enterDataBody() {
        TimeEntryValidator.dataBodyTimeEntry();
    }

    @Then("validate that the ids are not null")
    public void validateIdNotNull() {
        TimeEntryValidator.verifyIdInTimesEntries();
    }

    @Test(priority=5)
    @Then("the correct data is validated in time entry")
    public void correctDataValidatedInTimeEntry() {
        TimeEntryValidator.verifyDataTimeEntry();
    }

    @Test(priority=3)
    @Then("I get a response object with two properties")
    public void responseObjectWithProperties() {
        TimeEntryValidator.verifyErrorResponse();
    }
    @Test(priority=4)
    @And("I check if there is a time entry created")
    public void checkTimeEntryCreated() {
        TimeEntryValidator.verifyTimeEntryCreated();
    }

    @And("modify data of a time entry")
    public void modifyTimeEntryData() {
        TimeEntryValidator.getIdTimeEntry();
        TimeEntryValidator.dataBodyUpdate();
    }
    @And("a timeEntryId is obtained and set to url")
    public void aTimeEntryIdIsObtained() {
        TimeEntryValidator.setIdTimeEntry();
    }
    @Test(priority=6)
    @And("a timeEntryIds are obtained and set to url")
    public void aTimeEntryIdsAreObtainedAndSetToUrl() {
        TimeEntryValidator.setIdsTimeEntry();
    }
}
