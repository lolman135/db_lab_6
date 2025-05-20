package labs.db_lab_6.repository;

import labs.db_lab_6.entity.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextRepository extends JpaRepository<Long, Context> {
}
