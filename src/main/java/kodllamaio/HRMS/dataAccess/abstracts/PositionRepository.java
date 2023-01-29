package kodllamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodllamaio.HRMS.entities.concretes.Position;


public interface PositionRepository extends JpaRepository<Position,Integer> {

}
