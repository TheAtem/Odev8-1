package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobseekerService {
	
	DataResult<List<Jobseeker>> getAll();
	
	Result add(Jobseeker jobseeker);
	
	Result delete(String email);
	
	Result deleteAll();
	
	Jobseeker getByEmail(String email);
	
	boolean getByEmailOrIdentityNumber(String email, String identityNumber);
	
}
