package kodllamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodllamaio.HRMS.business.abstracts.JobTitleService;
import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitlesController {
	
	JobTitleService jobTitleService;

	public JobTitlesController(JobTitleService jobTitleService) {
		this.jobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll(){
		return jobTitleService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return jobTitleService.add(jobTitle);
	}
	
}
