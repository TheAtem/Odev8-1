package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(!getByJobName(jobPosition.getJobName())) {
			return new ErrorResult("Bu iş pozisyonundan sitemde mevcuttur.");
		}else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Data Eklendi.");
		}
	}

	@Override
	public boolean getByJobName(String jobName) {
		if(this.jobPositionDao.getByJobName(jobName) == null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Result deleteAll() {
		this.jobPositionDao.deleteAll();
		return new SuccessResult("Datalar silindi.");
	}
	

}
