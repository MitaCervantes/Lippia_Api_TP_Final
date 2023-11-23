package api.model.projects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TimeEstimate{
    public String estimate;
    public String type;
    public Object resetOption;
    public boolean active;
    public boolean includeNonBillable;
}
