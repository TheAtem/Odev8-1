package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.IsEmpty;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.core.results.Validation;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		String[] regex = employer.getWebAdres().split("www.",2);
		if(IsEmpty.isEmptyEmployer(employer)) {
			return new ErrorResult("Lütfen tüm alanları doldurunuz.");
		}else if(!Validation.email(employer.getEmail(), regex[1])) {
			return new ErrorResult("Geçerli bir email adresi giriniz.");
		}else if (!getByEmail(employer.getEmail())) {
			return new ErrorResult("Sistemde kaynınız bulunmaktadır.");
		}else if(!Validation.hrmsPersonel()) {
			return new ErrorResult("Personel onayı gerçekleşmedi.");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("Data Eklendi.");
		}
		
	}

	@Override
	public boolean getByEmail(String email) {
		if(this.employerDao.getByEmail(email) == null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Result deleteAll() {
		this.employerDao.deleteAll();
		return new SuccessResult("Datalar Silindi.");
	}

	

}
