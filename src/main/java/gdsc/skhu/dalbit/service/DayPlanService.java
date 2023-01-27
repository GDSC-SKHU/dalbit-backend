package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.DateCheckDTO;
import gdsc.skhu.dalbit.domain.DTO.request.DayPlanRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.DayPlanResponseDTO;
import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import gdsc.skhu.dalbit.domain.Memo;
import gdsc.skhu.dalbit.repository.DayPlanRepository;
import gdsc.skhu.dalbit.repository.MemberRepository;
import gdsc.skhu.dalbit.service.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DayPlanService {
    private final DayPlanRepository dayPlanRepository;
    private final MemberRepository memberRepository;

    public void checkLimitMoney(Long MemberId, LocalDate localDate, int limitMoney) {
        DayPlan dayPlan = dayPlanRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException());
        int totalSpentMoney = dayPlan.getMemos().stream().mapToInt(Memo::getSpentMoney).sum();
        if (dayPlan.getLimitMoney() < totalSpentMoney) {
            throw new CustomException("상한선 초과", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public DayPlanResponseDTO saveDayPlan(Principal principal, DayPlanRequestDTO dayPlanRequestDTO) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        DayPlan dayPlan = DayPlan.builder()
                .date(dayPlanRequestDTO.getLocalDate())
                .member(member)
                .limitMoney(dayPlanRequestDTO.getLimitMoney())
                .build();
        dayPlanRepository.save(dayPlan);
        return DayPlanResponseDTO.builder()
                .localDate(dayPlanRequestDTO.getLocalDate())
                .limitMoney(dayPlan.getLimitMoney())
                .build();
    }
}
