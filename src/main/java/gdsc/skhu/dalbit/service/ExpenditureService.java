package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.request.ExpenditureRequestDTO;
import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import gdsc.skhu.dalbit.domain.Expenditure;
import gdsc.skhu.dalbit.repository.DayPlanRepository;
import gdsc.skhu.dalbit.repository.MemberRepository;
import gdsc.skhu.dalbit.repository.ExpenditureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class ExpenditureService {

    private final ExpenditureRepository expenditureRepository;
    private final DayPlanRepository dayPlanRepository;
    private final MemberRepository memberRepository;

    public void saveExpenditure(Principal principal, ExpenditureRequestDTO expenditureRequestDTO) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        DayPlan dayPlan = dayPlanRepository.findByMemberAndLocalDate(member, expenditureRequestDTO.getLocalDate()).orElseThrow(() -> new IllegalArgumentException());
        expenditureRepository.save(Expenditure.builder()
                .dayPlan(dayPlan)
                .message(expenditureRequestDTO.getMessage())
                .spentMoney(expenditureRequestDTO.getSpentMoney())
                .build());
    }

}
