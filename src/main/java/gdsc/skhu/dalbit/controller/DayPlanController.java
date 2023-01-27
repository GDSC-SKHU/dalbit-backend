package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.DayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.DayPlanResponseDTO;
import gdsc.skhu.dalbit.service.DayPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DayPlanController {
    private final DayPlanService dayPlanService;

    @PostMapping("/dayplans")
    public ResponseEntity<DayPlanResponseDTO> saveDayPlan(Principal principal, @RequestBody  DayPlanRequestDTO dayPlanRequestDTO) {
        DayPlanResponseDTO dayPlanResponseDTO = dayPlanService.saveDayPlan(principal,dayPlanRequestDTO);
        return ResponseEntity.ok(dayPlanResponseDTO);
    }
}
