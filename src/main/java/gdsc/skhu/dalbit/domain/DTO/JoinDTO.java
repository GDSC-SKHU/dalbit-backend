package gdsc.skhu.dalbit.domain.DTO;

import gdsc.skhu.dalbit.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {
    private String username;
    private String password;
    private String repeatedPassword;
    private String nickname;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
