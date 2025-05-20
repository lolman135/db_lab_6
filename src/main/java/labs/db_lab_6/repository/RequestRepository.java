package labs.db_lab_6.repository;

import labs.db_lab_6.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Long, Request> {
}
