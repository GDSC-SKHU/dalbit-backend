package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.request.DayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.request.FindDayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.DayPlanResponseDTO;
import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import gdsc.skhu.dalbit.repository.DayPlanRepository;
import gdsc.skhu.dalbit.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class DayPlanService {
    private final DayPlanRepository dayPlanRepository;
    private final MemberRepository memberRepository;

    public void saveDayPlan(Principal principal, DayPlanRequestDTO dayPlanRequestDTO) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        DayPlan dayPlan = DayPlan.builder()
                .localDate(dayPlanRequestDTO.getLocalDate())
                .member(member)
                .limitMoney(dayPlanRequestDTO.getLimitMoney())
                .build();
        dayPlanRepository.save(dayPlan);
    }

    public DayPlanResponseDTO findDayPlan(Principal principal, FindDayPlanRequestDTO findDayPlanRequestDTO) {
        String username = principal.getName();
        Member member = memberRepository.findByUsername(username).get();
        DayPlan dayPlan = dayPlanRepository.findByMemberAndLocalDate(member, findDayPlanRequestDTO.getDate()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "day plan이 존재하지 않습니다."));
        return DayPlanResponseDTO.builder()
                .dayPlan(dayPlan)
                .build();
    }
}
