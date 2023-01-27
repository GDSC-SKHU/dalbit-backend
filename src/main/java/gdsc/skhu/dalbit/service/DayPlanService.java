package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.request.DayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.DayPlanResponseDTO;
import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import gdsc.skhu.dalbit.domain.Memo;
import gdsc.skhu.dalbit.repository.DayPlanRepository;
import gdsc.skhu.dalbit.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DayPlanService {
    private final DayPlanRepository dayPlanRepository;
    private final MemberRepository memberRepository;

    public DayPlanResponseDTO saveDayPlan(Principal principal, DayPlanRequestDTO dayPlanRequestDTO) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        DayPlan dayPlan = DayPlan.builder()
                .localDate(dayPlanRequestDTO.getLocalDate())
                .member(member)
                .limitMoney(dayPlanRequestDTO.getLimitMoney())
                .build();
        dayPlanRepository.save(dayPlan);
        return DayPlanResponseDTO.builder()
                .localDate(dayPlan.getLocalDate())
                .limitMoney(dayPlan.getLimitMoney())
                .build();
    }

    public DayPlanResponseDTO updateDayPlan(Principal principal, DayPlanRequestDTO dayPlanRequestDTO) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        Long dayPlanId = dayPlanRequestDTO.getId();
        DayPlan dayPlan = dayPlanRepository.findById(dayPlanId).get();
        List<Memo> expenditures = dayPlan.getMemos();
        int totalSpentMoney = 0;
        for(Memo memo : expenditures) {
            totalSpentMoney += memo.getSpentMoney();
        }
        DayPlan newDayPlan = DayPlan.builder()
                .id(dayPlanId)
                .localDate(dayPlan.getLocalDate())
                .member(member)
                .limitMoney(dayPlan.getLimitMoney())
                .memos(dayPlan.getMemos())
                .totalSpentMoney(totalSpentMoney)
                .build();
        dayPlanRepository.save(newDayPlan);
        return DayPlanResponseDTO.builder()
                .localDate(newDayPlan.getLocalDate())
                .limitMoney(newDayPlan.getLimitMoney())
                .build();
    }
}
