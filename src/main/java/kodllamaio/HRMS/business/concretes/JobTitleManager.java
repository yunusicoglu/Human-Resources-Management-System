package kodllamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodllamaio.HRMS.business.abstracts.JobTitleService;
import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodllamaio.HRMS.core.utilities.results.SuccessResult;
import kodllamaio.HRMS.dataAccess.abstracts.JobTitleRepository;
import kodllamaio.HRMS.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleRepository jobTitleRepository;
	
	public JobTitleManager(JobTitleRepository jobTitleRepository) {
		this.jobTitleRepository = jobTitleRepository;
	}
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(jobTitleRepository.findAll(), "Is pozisyonlari listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		
		jobTitleRepository.save(jobTitle);
		return new SuccessResult("Is pozisyonu eklendi.");
		
	}

	
	
}
