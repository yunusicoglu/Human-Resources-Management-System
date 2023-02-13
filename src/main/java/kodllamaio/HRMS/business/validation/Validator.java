package kodllamaio.HRMS.business.validation;

public class Validator {
	public String errorMessage;
	public String emailSentMessage;
	
	public Boolean isEmailValid(String email) {
		
		if (!(email.contains("@")&&email.contains("."))) {
			errorMessage="Geçersiz email!";
			return false;
		}
		return true;
	}
	
	public void sentEmailVerification(String email) {
		emailSentMessage = "Doğrulama kodunuz "+email+" adresine gönderildi." ;
	}
	
}
