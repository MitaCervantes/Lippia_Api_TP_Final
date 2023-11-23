package ar.validator;

import api.model.ClientResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class ClientValidator {
    public static void validateNameClient(String name){
        ClientResponse[] clientResponse = (ClientResponse[]) APIManager.getLastResponse().getResponse();

        Assert.assertEquals(clientResponse[0].getName(), name, "Los nombres no coinciden");
        Assert.assertTrue(clientResponse[0].getName().equalsIgnoreCase(name), "Los nombres no coinciden");
    }
}
