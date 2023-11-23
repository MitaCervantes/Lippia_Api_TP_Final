package ar.steps;

import ar.validator.ClientValidator;
import ar.validator.ProjectValidator;
import ar.validator.WorkspaceValidator;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.BaseService;
import services.ProjectService;
import services.WorkspaceService;

public class ClockifySteps extends PageSteps {
    @Given("^An account created in Clockify and x-api-key '(.*)' generated$")
    public static void AnAccountCreatedInClockifyAndTokenGenerated(String token){
        BaseService.X_API_KEY.set(token);
    }

    @Then("Obtengo los datos de mi Workspace")
    public void obtengoLosDatosDeMiWorkspace() {
        WorkspaceValidator.validate();
    }

    @And("obtengo un workspaceId")
    public void obtengoUnWorkspaceId() {
        WorkspaceService.defineWorkspaceId();
    }

    @And("^tengo un nombre de cliente (.*)$")
    public void tengoUnNombreDeCliente(String name) {
        BaseService.NAME_CLIENT.set(name);
    }

    @And("^el nombre del cliente es (.*)$")
    public void elNombreDelClienteEs(String nameClient) {
        ClientValidator.validateNameClient(nameClient);
    }

    @And("^tengo un nombre de proyecto (.*)$")
    public void tengoUnNombreDeProyecto(String name) {
        BaseService.NAME_PROJECT.set(name);
    }

    @And("^el nombre del proyecto es (.*)$")
    public void elNombreDelProyectoEs(String nameProject) {
        ProjectValidator.validateNameProject(nameProject);
    }


}
