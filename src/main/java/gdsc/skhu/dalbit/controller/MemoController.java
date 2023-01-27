package gdsc.skhu.dalbit.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import gdsc.skhu.dalbit.domain.DTO.request.AllMemosRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.request.MemoRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.MemoResponseDTO;
import gdsc.skhu.dalbit.domain.Memo;
import gdsc.skhu.dalbit.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<String> saveMemo(Principal principal, @RequestBody MemoRequestDTO memoRequestDTO) {
        memoService.saveMemo(principal, memoRequestDTO);
        return ResponseEntity.ok("저장성공");
    }
}
