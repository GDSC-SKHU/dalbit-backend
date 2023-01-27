package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.request.RecordRequestDto;
import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import gdsc.skhu.dalbit.domain.Record;
import gdsc.skhu.dalbit.repository.DayPlanRepository;
import gdsc.skhu.dalbit.repository.MemberRepository;
import gdsc.skhu.dalbit.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final MemberRepository memberRepository;
    private final DayPlanRepository dayPlanRepository;


    public void saveRecord(Principal principal, RecordRequestDto recordRequestDto) {
        String username = principal.getName();
        Member member = memberRepository.findByUsername(username).get();
        DayPlan dayPlan = dayPlanRepository.findByMemberAndLocalDate(member, recordRequestDto.getLocalDate()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Day Plan이 없습니다."));
        recordRepository.save(Record.builder()
                .dayPlan(dayPlan)
                .memo(recordRequestDto.getMemo())
                .build());
    }
}
