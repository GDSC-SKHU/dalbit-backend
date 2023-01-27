package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.request.DayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.DayPlanResponseDTO;
import gdsc.skhu.dalbit.service.DayPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DayPlanController {
    private DayPlanService dayPlanService;

    @PostMapping("/dayplans")
    public ResponseEntity<DayPlanResponseDTO> saveDayPlan(DayPlanRequestDTO dayPlanRquestDTO) {
        log.info("money={}", dayPlanRquestDTO.getLimitMoney());
        return ResponseEntity.ok(dayPlanService.saveDayPlan(dayPlanRquestDTO));
    }
}
