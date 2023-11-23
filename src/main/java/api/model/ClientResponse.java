package api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientResponse{
    public String id;
    public String name;
    public String email;
    public String workspaceId;
    public boolean archived;
    public String address;
    public String note;

    public String getName() {
        return this.name;
    }
}