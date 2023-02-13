package kodllamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodllamaio.HRMS.business.abstracts.JobSeekerService;
import kodllamaio.HRMS.core.utilities.results.DataResult;
import kodllamaio.HRMS.core.utilities.results.Result;
import kodllamaio.HRMS.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {
	JobSeekerService jobSeekerService;
	
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService=jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return jobSeekerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody @Valid JobSeeker jobSeeker) {
		return jobSeekerService.add(jobSeeker);
	}
	
	
	
}









