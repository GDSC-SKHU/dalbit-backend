package gdsc.skhu.dalbit.service;

import gdsc.skhu.dalbit.domain.DTO.JoinDTO;
import gdsc.skhu.dalbit.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(JoinDTO joinRequestDTO) {
        if(memberRepository.findByUsername(joinRequestDTO.getUsername()).isPresent()) {
            throw new IllegalStateException("Already exist username.");
        }
        if(!joinRequestDTO.getPassword().equals(joinRequestDTO.getRepeatedPassword())) {
            throw new IllegalStateException("Repeated password is not equal to password");
        }
        joinRequestDTO.setPassword(passwordEncoder.encode(joinRequestDTO.getPassword()));
        memberRepository.save(joinRequestDTO.toEntity());
    }
}
