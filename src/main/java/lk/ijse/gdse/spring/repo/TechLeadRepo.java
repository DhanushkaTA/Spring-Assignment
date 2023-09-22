package lk.ijse.gdse.spring.repo;

import lk.ijse.gdse.spring.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechLeadRepo extends JpaRepository<TechLead, String > {
}
