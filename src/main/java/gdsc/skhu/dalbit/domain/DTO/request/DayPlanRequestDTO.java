package gdsc.skhu.dalbit.domain.DTO.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DayPlanRequestDTO {
    LocalDate localDate;
    Long memberId;
    int limitMoney;

}
