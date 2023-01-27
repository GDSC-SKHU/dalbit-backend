package gdsc.skhu.dalbit.repository;

import gdsc.skhu.dalbit.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
