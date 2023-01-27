package gdsc.skhu.dalbit;

import gdsc.skhu.dalbit.domain.Member;
import gdsc.skhu.dalbit.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DalbitApplication {
	@Autowired
	MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(DalbitApplication.class, args);
	}

}
