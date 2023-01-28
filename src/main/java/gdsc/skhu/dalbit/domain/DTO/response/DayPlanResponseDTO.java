package gdsc.skhu.dalbit.domain.DTO.response;

import gdsc.skhu.dalbit.domain.DayPlan;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DayPlanResponseDTO {
    DayPlan dayPlan;
}
