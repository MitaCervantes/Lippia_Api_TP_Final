package services;

import api.model.timeEntry.TimeEntry;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;

public class TimeEntryService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, TimeEntry[].class, BaseService.setParams());
    }

}