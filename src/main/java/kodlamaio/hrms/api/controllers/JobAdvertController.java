package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.results.CitiesofTurkey;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.JobActivation;
import kodlamaio.hrms.core.results.JobPosition;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployerWithJobAdvert;

@RestController
@RequestMapping("/api/jobadvert")
public class JobAdvertController {

	
	private JobAdvertService jobAdvertService;
	@Autowired
	public JobAdvertController (JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert, @RequestParam(name = "cities") CitiesofTurkey cities,
			@RequestParam(name = "jobPosition") JobPosition jobPosition,
			@RequestParam(name = "jobActivation") JobActivation jobActivation) {
		jobAdvert.setJobActivation(jobActivation.toString());
		jobAdvert.setJobPosition(jobPosition.toString());
		jobAdvert.setCity(cities.toString());
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/deleteAll")
	public Result deleteAll() {
		return this.jobAdvertService.deleteAll();
	}
	
	@PostMapping("/EmployerWithJobAdvert")
	public DataResult<List<EmployerWithJobAdvert>> employerWithJobAdvertDetails() {
		return this.jobAdvertService.employerWithJobAdvertDetails();
	}
	
	@PostMapping("/EmployerWithJobAdvertActive")
	public DataResult<List<EmployerWithJobAdvert>> employerWithJobAdvertDetailsActive() {
		return this.jobAdvertService.employerWithJobAdvertActive("Active");
	}
	
	@PostMapping("/EmployerUpdateJobActivation")
	public Result employerUpdateJobActivation (@RequestParam(name = "jobActivation") JobActivation jobActivation, 
			@RequestParam(name = "jobAdverId") int jobAdverId) {		
				return this.jobAdvertService.updateJobAdvertActivation(this.jobAdvertService.getByJobAdvertID(jobAdverId),
						jobActivation.toString());
		
	}

}
