package kodllamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodllamaio.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer>{
	JobSeeker findByEmail(String email);
	JobSeeker findByIdentityNumber(String identityNumber);
}
