package ar.validator;

import api.model.timeEntry.TimeEntry;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class TimeEntryValidator {
    public static void verifyIdInAllTimesEntries() {
        TimeEntry[] response = (TimeEntry[]) APIManager.getLastResponse().getResponse();
        for (TimeEntry entry : response) {
            Assert.assertNotNull(entry.getId(), "El id es null");
            System.out.println("entry = " + entry);
        }
    }
}
