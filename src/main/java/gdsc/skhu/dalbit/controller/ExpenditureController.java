package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.MemoRequestDTO;
import gdsc.skhu.dalbit.service.ExpenditureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExpenditureController {
    private final ExpenditureService expenditureService;



    @PostMapping("/memos")
    public ResponseEntity<String> saveMemo(Principal principal, @RequestBody MemoRequestDTO memoRequestDTO) {
        expenditureService.saveMemo(principal,memoRequestDTO);
        return ResponseEntity.ok("저장하였습니다.");
    }
}
