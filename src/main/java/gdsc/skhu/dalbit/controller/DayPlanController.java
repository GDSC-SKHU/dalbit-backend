package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.DayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.request.FindDayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.DayPlanResponseDTO;
import gdsc.skhu.dalbit.service.DayPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DayPlanController {
    private final DayPlanService dayPlanService;

    @GetMapping("/dayplans/{localDate}")
    public ResponseEntity<DayPlanResponseDTO> findDayPlan(Principal principal, @PathVariable(name = "localDate") String localDateString) {
        LocalDate localDate = LocalDate.parse(localDateString, DateTimeFormatter.ISO_DATE);
        return ResponseEntity.ok(dayPlanService.findDayPlan(principal, localDate));
    }

    @PostMapping("/dayplans")
    public ResponseEntity<String> saveDayPlan(Principal principal, @RequestBody DayPlanRequestDTO dayPlanRequestDTO) {
        dayPlanService.saveDayPlan(principal, dayPlanRequestDTO);
        return ResponseEntity.ok("저장되었습니다.");
    }

    @PatchMapping("/dayplans")
    public ResponseEntity<DayPlanResponseDTO> updateDayPlan(Principal principal, @RequestBody DayPlanRequestDTO dayPlanRequestDTO) {
        DayPlanResponseDTO dayPlanResponseDTO = dayPlanService.updateDayPlan(principal,dayPlanRequestDTO);
        return ResponseEntity.ok(dayPlanResponseDTO);
    }
}
