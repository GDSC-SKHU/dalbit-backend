package gdsc.skhu.dalbit.repository;

import gdsc.skhu.dalbit.domain.DayPlan;
import gdsc.skhu.dalbit.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DayPlanRepository extends JpaRepository<DayPlan, Long> {
    Optional<DayPlan> findByDateAndMember(LocalDate date, Member member);
}
