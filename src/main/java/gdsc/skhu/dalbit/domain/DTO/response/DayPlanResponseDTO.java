package gdsc.skhu.dalbit.domain.DTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import gdsc.skhu.dalbit.domain.DayPlan;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class DayPlanResponseDTO {
    DayPlan dayPlan;
}
