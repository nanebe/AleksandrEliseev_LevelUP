package api.gorest.model.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationModel {
    private long total;
    private long pages;
    private long page;
    private long limit;
}
