package gdsc.skhu.dalbit.domain.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class DateCheckDTO {
    LocalDate localDate;
    int spentMoney;
}
