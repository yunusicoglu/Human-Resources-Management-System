package kodllamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodllamaio.HRMS.entities.concretes.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
	Employer findByEmail(String email);
}
