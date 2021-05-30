package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.IsEmpty;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.core.results.Validation;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobseekerService{

	private JobseekerDao jobseekerDao;
	
	@Autowired
	public JobseekerManager (JobseekerDao jobseekerDao) {
		this.jobseekerDao = jobseekerDao;
	}
	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(jobseekerDao.findAll(), "Data Listelendi.");
	}

	@Override
	public Result add(Jobseeker jobseeker) {
		if(IsEmpty.isEmptyJobseeker(jobseeker)) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}else if (!Validation.email(jobseeker.getEmail())){
			return new ErrorResult("Lütfen geçerli bir email adresi giriniz.");
		}else if(!Validation.identityNumber(jobseeker.getIdentityNumber())) {
			return new ErrorResult("Yanlış veya eksik kimlik numarısı girdiniz.");
		}else if(!getByEmailOrIdentityNumber(jobseeker.getEmail(), jobseeker.getIdentityNumber())) {
			return new ErrorResult("Sistemde kaydınız. Bulunmaktadır.");
		}else {
			this.jobseekerDao.save(jobseeker);
			return new SuccessResult("Data eklendi.");
		}
	}

	@Override
	public Jobseeker getByEmail(String email) {
		return this.jobseekerDao.getByEmail(email);
	}

	@Override
	public Result delete(String email) {
		this.jobseekerDao.delete(getByEmail(email));
		return new SuccessResult("Data silindi.");
	}
	

	@Override
	public boolean getByEmailOrIdentityNumber(String email, String identityNumber) {
		if(this.jobseekerDao.getByEmailOrIdentityNumber(email, identityNumber) == null) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Result deleteAll() {
		this.jobseekerDao.deleteAll();
		return new SuccessResult("Datalar silindi.");
	}
	

}
