package kodllamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodllamaio.HRMS.business.abstracts.JobSeekerService;
import kodllamaio.HRMS.business.validation.JobSeekerValidator;
import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.ErrorResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodllamaio.HRMS.core.utilities.results.SuccessResult;
import kodllamaio.HRMS.dataAccess.abstracts.JobSeekerRepository;
import kodllamaio.HRMS.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	private String errorMessage;
	private String emailSentMessage;
	
	JobSeekerRepository jobSeekerRepository;
		
	public JobSeekerManager(JobSeekerRepository jobSeekerRepository) {
		this.jobSeekerRepository = jobSeekerRepository;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerRepository.findAll(), "Is arayanlar listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if (!(validate(jobSeeker))) {
			return new ErrorResult(errorMessage);
		} 
		jobSeekerRepository.save(jobSeeker);
		return new SuccessResult("Is arayan bilgisi kaydedildi."+" "+emailSentMessage);
	}
	
	private Boolean validate(JobSeeker jobSeeker) {
		
		JobSeekerValidator jobSeekerValidator = new JobSeekerValidator(jobSeekerRepository);
		
		if (!(jobSeekerValidator.isIdentityNumberValid(jobSeeker.getIdentityNumber()))) {
			errorMessage=jobSeekerValidator.errorMessage;
			return false;
		}else if (jobSeekerValidator.isIdentityExist(jobSeeker.getIdentityNumber())) {
			errorMessage=jobSeekerValidator.errorMessage;
			return false;
		}else if (!(jobSeekerValidator.isEmailValid(jobSeeker.getEmail()))) {
			errorMessage=jobSeekerValidator.errorMessage;
			return false;
		}else if (jobSeekerValidator.isEmailExist(jobSeeker.getEmail())) {
			errorMessage=jobSeekerValidator.errorMessage;
			return false;
		}
		
		jobSeekerValidator.sentEmailVerification(jobSeeker.getEmail());
		emailSentMessage=jobSeekerValidator.emailSentMessage;
		return true;
	}

}
