package api.gorest.model.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetaModel {
    private PaginationModel pagination;
}
