package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.RecordRequestDto;
import gdsc.skhu.dalbit.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @PostMapping("/records")
    public ResponseEntity<String> saveRecord(Principal principal, @RequestBody RecordRequestDto recordRequestDto) {
        recordService.saveRecord(principal,recordRequestDto);
        return ResponseEntity.ok("Save record success");
    }
}
