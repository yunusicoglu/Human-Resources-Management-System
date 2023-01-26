package kodllamaio.HRMS.business.abstracts;

import java.util.List;

import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	Result add(JobTitle jobTitle);
}
