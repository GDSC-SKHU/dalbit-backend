package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.MemoRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.MemoResponseDTO;
import gdsc.skhu.dalbit.domain.Memo;
import gdsc.skhu.dalbit.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping("/memos")
    public ResponseEntity<?> findAllMemo(Principal principal,@RequestBody LocalDate localDate) {
        memoService.findAllMemo(principal,localDate);
        return ResponseEntity.ok("findAll");
    }

    @PostMapping("/memos")
    public ResponseEntity<String> saveMemo(Principal principal, @RequestBody MemoRequestDTO memoRequestDTO) {
        memoService.saveMemo(principal,memoRequestDTO);
        return ResponseEntity.ok("저장성공");
    }
}
