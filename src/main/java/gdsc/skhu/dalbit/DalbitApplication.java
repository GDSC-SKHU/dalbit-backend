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

	@PostConstruct
	void init() {
		Member 전홍영 = Member.builder().name("전홍영").build();
		memberRepository.save(전홍영);
	}
	public static void main(String[] args) {
		SpringApplication.run(DalbitApplication.class, args);
	}

}
