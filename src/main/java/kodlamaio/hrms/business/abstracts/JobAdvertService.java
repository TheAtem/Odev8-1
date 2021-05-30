package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployerWithJobAdvert;

public interface JobAdvertService {

	DataResult<List<JobAdvert>> getAll();
	
	Result add(JobAdvert jobAdvet);
	
	Result deleteAll();
	
	Result updateJobAdvertActivation(JobAdvert jobAdvert, String active);
	
	JobAdvert getByJobAdvertID(int jobAdverId);
	
	DataResult<List<EmployerWithJobAdvert>> employerWithJobAdvertDetails();
	
	DataResult<List<EmployerWithJobAdvert>> employerWithJobAdvertActive(String active);
	
}
