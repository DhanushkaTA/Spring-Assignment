package lk.ijse.gdse.spring.repo;

import lk.ijse.gdse.spring.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer > {


}
