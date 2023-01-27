package gdsc.skhu.dalbit.controller;

import gdsc.skhu.dalbit.domain.DTO.LoginDTO;
import gdsc.skhu.dalbit.domain.DTO.TokenDTO;
import gdsc.skhu.dalbit.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public TokenDTO login(@RequestBody LoginDTO loginRequestDTO) {
        return loginService.login(loginRequestDTO);
    }
}
