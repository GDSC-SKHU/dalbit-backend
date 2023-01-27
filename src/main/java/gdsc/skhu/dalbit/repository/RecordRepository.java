package gdsc.skhu.dalbit.repository;

import gdsc.skhu.dalbit.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
}
