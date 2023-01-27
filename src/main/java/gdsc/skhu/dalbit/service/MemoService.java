package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.request.MemoRequestDTO;
import gdsc.skhu.dalbit.domain.DTO.response.MemoResponseDTO;
import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import gdsc.skhu.dalbit.domain.Memo;
import gdsc.skhu.dalbit.repository.DayPlanRepository;
import gdsc.skhu.dalbit.repository.MemberRepository;
import gdsc.skhu.dalbit.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;
    private final DayPlanRepository dayPlanRepository;
    private final MemberRepository memberRepository;

    public void saveMemo(Principal principal,MemoRequestDTO memoRequestDTO) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        DayPlan dayPlan = dayPlanRepository.findByDateAndMember(memoRequestDTO.getDate(),member).orElseThrow(() -> new IllegalArgumentException());
        memoRepository.save(Memo.builder()
                .dayPlan(dayPlan)
                .message(memoRequestDTO.getMessage())
                .spentMoney(memoRequestDTO.getSpentMoney())
                .build());
    }

    public void findAllMemo(Principal principal, LocalDate localDate) {
        String name = principal.getName();
        Member member = memberRepository.findByUsername(name).get();
        DayPlan dayPlan = dayPlanRepository.findByDateAndMember(localDate, member).orElseThrow(() -> new IllegalArgumentException());

    }
}
