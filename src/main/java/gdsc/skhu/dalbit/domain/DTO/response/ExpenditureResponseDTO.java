package gdsc.skhu.dalbit.domain.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenditureResponseDTO {
    private String message;
    private int spentMoney;
}
