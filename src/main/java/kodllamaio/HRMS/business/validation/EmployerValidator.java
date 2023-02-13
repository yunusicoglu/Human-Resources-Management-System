package kodllamaio.HRMS.business.validation;

import kodllamaio.HRMS.dataAccess.abstracts.EmployerRepository;

public class EmployerValidator extends Validator{
	
	EmployerRepository employerRepository;	
	public EmployerValidator(EmployerRepository employerRepository) {
		this.employerRepository = employerRepository;
	}


	public Boolean isEmailExist(String email) {
		
		if (!(employerRepository.findByEmail(email)==null)) {
			errorMessage="Bu email adresi ile daha önce kayıt yapılmıştır!";
			return true;
		}
		
		return false;
	}
	
	public Boolean isEmailEqualToDomain(String email, String webAddress) {
		
		int indexOfAtSign = email.indexOf("@");
		String emailBody = email.substring(0, indexOfAtSign);
		
		
		int lengthOfWebAddress = webAddress.length();
		
		String domain;
		if (webAddress.substring(0, 4).equals("www.")) {
			domain = webAddress.substring(4, lengthOfWebAddress);
		} else {
			domain = webAddress.substring(0, lengthOfWebAddress);
		}
			
		if (!(emailBody.equals(domain))) {
			errorMessage = "Email ile domain aynı olmalı!";
			return false;
		}
		
		return true;
	}
	
	
}



















