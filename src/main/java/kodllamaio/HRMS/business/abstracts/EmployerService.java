package kodllamaio.HRMS.business.abstracts;
//
import java.util.List;

import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
