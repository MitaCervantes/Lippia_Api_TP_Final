package services;

import api.model.ClientResponse;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ClientService extends BaseService{

    public static Response getclient(String jsonName){return get(jsonName, ClientResponse[].class, setParams());}

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key",X_API_KEY.get());
        params.put("id-workspace",WORKSPACE_ID_0.get());
        return params;
    }

    public static Response post(String jsonName) {return post(jsonName,ClientResponse.class ,setParams());}
}
