package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.DayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.request.FindDayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.DayPlanResponseDTO;
import gdsc.skhu.dalbit.service.DayPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DayPlanController {
    private final DayPlanService dayPlanService;

    @GetMapping("/dayplans")
    public ResponseEntity<DayPlanResponseDTO> findDayPlan(Principal principal,@RequestBody FindDayPlanRequestDTO findDayPlanRequestDTO) {
        return ResponseEntity.ok(dayPlanService.findDayPlan(principal,findDayPlanRequestDTO));
    }
    @PostMapping("/dayplans")
    public ResponseEntity<String> saveDayPlan(Principal principal, @RequestBody DayPlanRequestDTO dayPlanRequestDTO) {
        dayPlanService.saveDayPlan(principal, dayPlanRequestDTO);
        return ResponseEntity.ok("저장되었습니다.");
    }
}
