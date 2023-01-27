package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.MemoRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.MemoResponseDTO;
import gdsc.skhu.dalbit.domain.Memo;
import gdsc.skhu.dalbit.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping("/memos")
    public ResponseEntity<?> findAllMemo() {
        memoService.findAllMemo();
        return ResponseEntity.ok("findAll");
    }

    @PostMapping("/memos")
    public ResponseEntity<String> saveMemo(@RequestBody MemoRequestDTO memoRequestDTO) {
        memoService.saveMemo(memoRequestDTO);
        return ResponseEntity.ok("저장성공");
    }
}