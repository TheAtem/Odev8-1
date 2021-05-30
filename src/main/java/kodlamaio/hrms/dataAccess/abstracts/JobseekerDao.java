package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobseekerDao extends JpaRepository<Jobseeker, Integer>{

	Jobseeker getByEmailOrIdentityNumber(String email, String identityNumber);
	
	Jobseeker getByEmail(String email);
}
