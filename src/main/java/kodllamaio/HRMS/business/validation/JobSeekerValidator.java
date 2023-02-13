package kodllamaio.HRMS.business.validation;

import kodllamaio.HRMS.dataAccess.abstracts.JobSeekerRepository;
import kodllamaio.HRMS.entities.concretes.JobSeeker;

public class JobSeekerValidator extends Validator{
	JobSeekerRepository jobSeekerRepository;
	
	public JobSeekerValidator(JobSeekerRepository jobSeekerRepository) {
		this.jobSeekerRepository = jobSeekerRepository;
	}
	
	public Boolean isIdentityNumberValid(String identityNumber){
		
		if (!(identityNumber.length()==11)) {
			
			errorMessage="Kimlik numarası 11 haneli olmalıdır.";
			return false;
			
		}
		for (int i = 0; i < identityNumber.length(); i++) {
			if (Character.isLetter(identityNumber.charAt(i))) {
				errorMessage="Kimlik numarasında harf bulunamaz.";
				return false;
			}
		}
		return true;
	}
	
	public Boolean isIdentityExist(String identityNumber) {
		
		JobSeeker isIdentityNumberExist = jobSeekerRepository.findByIdentityNumber(identityNumber);
		
		if (!(isIdentityNumberExist==null)) {
			errorMessage="Bu kimlik numarası ile daha önce kayıt yapılmıştır!";
			return true;
		}
		return false;
	}
	
	public Boolean isEmailExist(String email) {
		
		JobSeeker isEmailExist = jobSeekerRepository.findByEmail(email);
		if (!(isEmailExist==null)) {
			errorMessage="Bu E-mail adresi ile daha önce kayit yapılmıştır!";
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}


