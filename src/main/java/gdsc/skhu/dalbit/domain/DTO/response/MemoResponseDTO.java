package gdsc.skhu.dalbit.domain.DTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import gdsc.skhu.dalbit.domain.Memo;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MemoResponseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate localDate;


    List<Memo> memos;

}
