package services;

import com.crowdar.api.rest.MethodsService;
import java.util.HashMap;
import java.util.Map;


public class BaseService extends MethodsService{

    public static Map<String, String> params = new HashMap<>();

    public static void AddParams(String clave, String valor) {
        params.put(clave, valor);
    }

    public static Map<String, String> setParams() {
        return params;
    }


}
