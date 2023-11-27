package ar.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import services.BaseService;
import io.github.cdimascio.dotenv.Dotenv;

public class BasicSteps {
    Dotenv dotenv = Dotenv.configure().directory("src/main/resources/env").load();

    @Given("A registered account in clockify and valid X-Api-Key")
    public void XApiKey_Valida() {
        BaseService.AddParams("base.url", dotenv.get("BASE_URL"));
        BaseService.AddParams("api_key", System.getenv("API_KEY"));
    }

    @And("a valid workspaceId is entered")
    public void inputWorkspaceIdValido() {
        BaseService.AddParams("workspace_id", dotenv.get("WORKSPACE_ID"));
    }
}
