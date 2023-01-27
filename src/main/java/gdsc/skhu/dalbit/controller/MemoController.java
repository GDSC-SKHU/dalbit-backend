package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.MemoRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.MemoResponseDTO;
import gdsc.skhu.dalbit.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<MemoResponseDTO> saveMemo(MemoRequestDTO memoRequestDTO) {
        return ResponseEntity.ok(memoService.saveMemo(memoRequestDTO));
    }
}
