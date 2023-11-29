package ar.validator;

import api.model.ErrorResponse;
import api.model.timeEntry.TimeEntry;
import com.crowdar.api.rest.APIManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.Assert;
import services.BaseService;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeEntryValidator {
    static Dotenv dotenv = Dotenv.configure().directory("src/main/resources/env").load();

    public static void verifyIdInTimesEntries() {
        TimeEntry[] response = (TimeEntry[]) APIManager.getLastResponse().getResponse();
        for (TimeEntry entry : response) {
            Assert.assertNotNull(entry.getId(), "El id es null");
            System.out.println("entry = " + entry);
        }
    }

    public static void dataBodyTimeEntry() {
        BaseService.AddParams("project_id", dotenv.get("PROJECT_ID"));
        BaseService.AddParams("task_id", dotenv.get("TASK_ID"));
        BaseService.AddParams("start_time", TpUtils.horaInicio());
        BaseService.AddParams("descripcion", dotenv.get("TIME_ENTRY_DESC"));
        BaseService.AddParams("end_time", TpUtils.horaFin());
    }

    public static void verifyDataTimeEntry() {
        TimeEntry response = (TimeEntry) APIManager.getLastResponse().getResponse();
        String descripcion = BaseService.params.get("descripcion");
        String project_id = BaseService.params.get("project_id");
        Assert.assertEquals(response.getDescription(), descripcion,"El dato no concuerda: ");
        Assert.assertEquals(response.getProjectId(), project_id,"El project_id no concuerda: ");
    }

    public static void verifyErrorResponse(){
        ErrorResponse response = (ErrorResponse) APIManager.getLastResponse().getResponse();
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(response);
        JsonElement jsonElement = new JsonParser().parse(jsonResponse);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Assert.assertEquals(jsonObject.size(), 2, "El response no tiene 2 propiedades");
    }

    public static void verifyTimeEntryCreated(){
        TimeEntry[] response = (TimeEntry[]) APIManager.getLastResponse().getResponse();
        Assert.assertTrue(response.length > 0, "No hay time entries.");
    }

    public static String idTimeEntry;

    public static void getIdTimeEntry(){
        TimeEntry[] response = (TimeEntry[]) APIManager.getLastResponse().getResponse();
        if (response.length>0){
            TimeEntry objTimeEntry = Arrays.stream(response).findAny().get();
            idTimeEntry = objTimeEntry.getId();
        }
    }

    public static void dataBodyUpdate() {
        BaseService.AddParams("time_entry_id", idTimeEntry);
        BaseService.AddParams("project_id",dotenv.get("PROJECT_ID"));
        BaseService.AddParams("start_time", TpUtils.horaInicio());
        BaseService.AddParams("descripcion", dotenv.get("UPDATE_DESCRIPTION"));
        BaseService.AddParams("end_time", TpUtils.horaFin());
    }

    public static void setIdTimeEntry(){
        TimeEntry[] responses = (TimeEntry[]) APIManager.getLastResponse().getResponse();
        if (responses.length > 0) {
            TimeEntry response = responses[0];
            BaseService.AddParams("time_entry_id", response.getId());
        }
    }

    private static String ids;
    public static void setIdsTimeEntry(){
        TimeEntry[] responses = (TimeEntry[]) APIManager.getLastResponse().getResponse();
        if (responses.length > 0) {
            List<String> timeEntryIds = new ArrayList<>();
            for (TimeEntry response : responses) {
                timeEntryIds.add(response.getId());
            }
            String[] arrayIds = timeEntryIds.toArray(new String[0]);
            Arrays.toString(arrayIds);
            ids = String.join(",", arrayIds);
            System.out.println("commaSeparatedIds = " + ids);
            BaseService.AddParams("ids", ids);
            System.out.println("arrayIds = " + Arrays.toString(arrayIds));
        }
        BaseService.AddParams("ids", ids);

    }
}
