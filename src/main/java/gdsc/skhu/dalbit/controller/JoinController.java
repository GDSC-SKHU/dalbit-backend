package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.JoinDTO;
import gdsc.skhu.dalbit.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDTO joinRequestDto) {
        joinService.join(joinRequestDto);
        return ResponseEntity.ok("Join success");
    }
}
