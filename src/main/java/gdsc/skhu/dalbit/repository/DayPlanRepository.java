package gdsc.skhu.dalbit.repository;

import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface DayPlanRepository extends JpaRepository<DayPlan, Long> {
    Optional<DayPlan> findByMemberAndLocalDate(Member member, LocalDate localDate);

}
