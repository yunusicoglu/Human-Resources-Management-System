package kodllamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodllamaio.HRMS.business.abstracts.EmployerService;
import kodllamaio.HRMS.business.validation.EmployerValidator;
import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.ErrorResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodllamaio.HRMS.core.utilities.results.SuccessResult;
import kodllamaio.HRMS.dataAccess.abstracts.EmployerRepository;
import kodllamaio.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private String errorMessage;
	private String emailSentMessage;
	
	private EmployerRepository employerRepository;
		
	public EmployerManager(EmployerRepository employerRepository) {
		this.employerRepository = employerRepository;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerRepository.findAll(), "Isverenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		if (!(validate(employer))) {
			return new ErrorResult(errorMessage);
		}
		
		employerRepository.save(employer);
		return new SuccessResult("Isveren bilgisi kaydedildi."+" "+emailSentMessage);
		
	}
	
	public Boolean validate(Employer employer) {
		EmployerValidator employerValidator = new EmployerValidator(employerRepository);
		
		if (!(employerValidator.isEmailValid(employer.getEmail()))) {
			errorMessage = employerValidator.errorMessage;
			return false;
		}
		if (employerValidator.isEmailExist(employer.getEmail())) {
			errorMessage = employerValidator.errorMessage;
			return false;
		}
		if (!(employerValidator.isEmailEqualToDomain(employer.getEmail(), employer.getWebAddress()))) {
			errorMessage = employerValidator.errorMessage;
			return false;
		}
		
		employerValidator.sentEmailVerification(employer.getEmail());
		emailSentMessage = employerValidator.emailSentMessage;
		return true;
	}

}








