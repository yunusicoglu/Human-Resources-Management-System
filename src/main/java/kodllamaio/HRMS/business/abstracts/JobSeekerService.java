package kodllamaio.HRMS.business.abstracts;

import java.util.List;

import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
}
