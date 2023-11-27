package ar.apiExampleProject;
import com.crowdar.api.rest.Response;
import gherkin.ast.Scenario;
import io.cucumber.java.*;
import org.apache.log4j.Logger;
import services.EmptyService;

public class Hooks {

    @Before()
    public void setScenario(Scenario scenario) {
        Logger.getRootLogger().info("-----------" + scenario.getName() + "-----------");
    }

    @After()
    public void dismissAll(Scenario scenario) {
        Logger.getRootLogger().info(" ending -----------" + scenario.getName() + "-----------");

    }

    private EmptyService emptyService;

    @Before()
    public void setUp() {
        emptyService = new EmptyService();
    }

    @After()
    public void deleteTimeEntry() {
        if (emptyService != null) {
            Response response = emptyService.delete("deleteTimeEntry");
            System.out.println("response = " + response);
        }
    }

}
