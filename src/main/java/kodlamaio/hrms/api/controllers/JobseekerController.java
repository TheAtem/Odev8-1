package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/jobsekeers")
public class JobseekerController {
	
	private JobseekerService jobseekerService;
	
	@Autowired
	public JobseekerController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}

	
	@GetMapping(value = "/getall")
	public DataResult<List<Jobseeker>> getAll()
	{
		return this.jobseekerService.getAll();
	}

	@PostMapping(path = "/add")
	public Result add(@RequestBody() Jobseeker jobseeker) {
		return this.jobseekerService.add(jobseeker);
	}
	
	@PostMapping("/delete")
	Result delete(@RequestParam(value = "email") String email) {
		try {
			return this.jobseekerService.delete(email);
		}catch (NullPointerException e) {
			return new ErrorResult("Eksik yada yanlış bilgi girdiniz.");
		}
		
		
	}
	@PostMapping("/deletall")
	public Result deleteAll() {
		return this.jobseekerService.deleteAll();
	}
	
	
}
