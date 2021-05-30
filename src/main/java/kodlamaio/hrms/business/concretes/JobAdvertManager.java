package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.IsEmpty;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.EmployerWithJobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdverDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdverDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdverDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if(IsEmpty.isEmptyJobAdvert(jobAdvert)) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}else {
			this.jobAdverDao.save(jobAdvert);
			return new SuccessResult("Data eklendi.");
		}
		
	}

	@Override
	public Result deleteAll() {
		this.jobAdverDao.deleteAll();
		return new SuccessResult("Datalar silindi.");
	}

	@Override
	public DataResult<List<EmployerWithJobAdvert>> employerWithJobAdvertDetails() {
		return new SuccessDataResult<List<EmployerWithJobAdvert>>(this.jobAdverDao.employerWithJobAdvertDetails(),
				"Data Listelendi.");
	}
	
	public DataResult<List<EmployerWithJobAdvert>> employerWithJobAdvertActive(String active) {
		return new SuccessDataResult<List<EmployerWithJobAdvert>>(this.jobAdverDao.employerWithJobAdvertActive(active),
				"Data Listelendi.");
	}

	@Override
	public JobAdvert getByJobAdvertID(int jobAdverId) {
		return this.jobAdverDao.getByJobAdvertID(jobAdverId);
	}

	@Override
	public Result updateJobAdvertActivation(JobAdvert jobAdvert, String active) {
		jobAdvert.setJobActivation(active);
		this.jobAdverDao.save(jobAdvert);
		return new SuccessResult("Data Güncellendi.");
	}

}
