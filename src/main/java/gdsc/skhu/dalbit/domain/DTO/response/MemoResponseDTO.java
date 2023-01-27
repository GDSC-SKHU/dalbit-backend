package gdsc.skhu.dalbit.domain.DTO.response;

import gdsc.skhu.dalbit.domain.Memo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MemoResponseDTO {
    LocalDate date;
    List<Memo> memos;

}
