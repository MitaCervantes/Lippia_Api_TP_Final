package services;

import api.model.timeEntry.TimeEntry;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;

public class TimeEntryService extends MethodsService {

    public static Response get(String jsonName) {

        return get(jsonName, TimeEntry[].class, BaseService.setParams());
    }

    public static Response post(String jsonName) {
        return post(jsonName, TimeEntry.class, BaseService.setParams());
    }

    public static Response put(String jsonName) {
        return put(jsonName, TimeEntry.class, BaseService.setParams());
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, TimeEntry.class, BaseService.setParams());
    }

}
