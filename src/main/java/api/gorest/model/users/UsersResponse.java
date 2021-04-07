package api.gorest.model.users;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsersResponse {
    private int code;
    private MetaModel meta;
    private List<UserModel> data;
}
