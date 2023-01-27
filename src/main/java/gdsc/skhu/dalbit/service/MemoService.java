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

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;
    private final DayPlanRepository dayPlanRepository;
    private final MemberRepository memberRepository;

    public void saveMemo(MemoRequestDTO memoRequestDTO) {
        Member member = memberRepository.findById(memoRequestDTO.getMemberId()).get();
        DayPlan dayPlan = dayPlanRepository.findByDateAndMember(memoRequestDTO.getDate(),member).orElseThrow(() -> new IllegalArgumentException());
        Memo example = Memo.builder()
                .dayPlan(dayPlan)
                .message(memoRequestDTO.getMessage())
                .spentMoney(memoRequestDTO.getSpentMoney())
                .build();
        memoRepository.save(example);
    }

    public void findAllMemo() {
    }
}
