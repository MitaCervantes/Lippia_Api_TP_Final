package services;

import api.model.EmptyResponse;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;


public class EmptyService extends MethodsService {

    public static Response delete(String jsonName) {
        return delete(jsonName, EmptyResponse.class, BaseService.setParams());
    }


}
