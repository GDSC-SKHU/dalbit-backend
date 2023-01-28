package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.ExpenditureRequestDTO;
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

    @PostMapping("/expenditures")
    public ResponseEntity<String> saveExpenditure(Principal principal, @RequestBody ExpenditureRequestDTO expenditureRequestDTO) {
        expenditureService.saveExpenditure(principal, expenditureRequestDTO);
        return ResponseEntity.ok("Save expenditure success");
    }
}
