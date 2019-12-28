package takred.passporttable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassportHistoryRepository extends JpaRepository<Passport, Long> {
}
