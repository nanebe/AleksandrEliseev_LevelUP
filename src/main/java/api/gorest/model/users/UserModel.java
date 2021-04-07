package api.gorest.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private String id;
    private String name;
    private String email;
    private Gender gender;
    private Status status;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
}

enum Status {
    ACTIVE,
    INACTIVE
}

enum Gender {
    MALE,
    FEMALE
}
