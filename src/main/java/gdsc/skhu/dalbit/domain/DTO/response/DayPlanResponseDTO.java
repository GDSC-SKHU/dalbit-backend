package gdsc.skhu.dalbit.domain.DTO.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class DayPlanResponseDTO {
    LocalDate localDate;
    int limitMoney;
}
