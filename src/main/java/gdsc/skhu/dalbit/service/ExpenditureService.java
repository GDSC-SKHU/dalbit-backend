package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.request.MemoRequestDTO;
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

    public void saveMemo(Principal principal,MemoRequestDTO memoRequestDTO) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        DayPlan dayPlan = dayPlanRepository.findByMemberAndLocalDate(member, memoRequestDTO.getDate()).orElseThrow(() -> new IllegalArgumentException());
        expenditureRepository.save(Expenditure.builder()
                .dayPlan(dayPlan)
                .message(memoRequestDTO.getMessage())
                .spentMoney(memoRequestDTO.getSpentMoney())
                .build());
    }

}
