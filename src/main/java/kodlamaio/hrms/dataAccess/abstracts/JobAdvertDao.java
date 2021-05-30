package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployerWithJobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	@Query("select new kodlamaio.hrms.entities.dtos.EmployerWithJobAdvert(e.companyName, j.jobPosition, j.openPositionNumber, j.relaeseDate,"
			+" j.deadline) From JobAdvert j Inner Join j.employers e")
	List<EmployerWithJobAdvert> employerWithJobAdvertDetails();
	
	@Query("select new kodlamaio.hrms.entities.dtos.EmployerWithJobAdvert(e.companyName, j.jobPosition, j.openPositionNumber, j.relaeseDate,"
			+" j.deadline) From JobAdvert j Inner Join j.employers e where j.jobActivation "
			+ "like %?1")
	List<EmployerWithJobAdvert> employerWithJobAdvertActive(String active);
	
	JobAdvert getByJobAdvertID(int jobAdverId);
}
