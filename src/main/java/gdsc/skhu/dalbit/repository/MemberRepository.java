package gdsc.skhu.dalbit.repository;

import gdsc.skhu.dalbit.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
