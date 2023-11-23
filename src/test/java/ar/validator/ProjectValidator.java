package ar.validator;

import api.model.projects.ProjectResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class ProjectValidator {
    public static void validateNameProject(String name){
        ProjectResponse[] projectResponse = (ProjectResponse[]) APIManager.getLastResponse().getResponse();

        Assert.assertEquals(projectResponse[0].getName(), name, "Los nombres no coinciden");
        Assert.assertTrue(projectResponse[0].getName().equalsIgnoreCase(name), "Los nombres no coinciden");
    }

}
