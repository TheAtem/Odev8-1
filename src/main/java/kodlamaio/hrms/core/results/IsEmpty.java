package kodlamaio.hrms.core.results;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.Jobseeker;

public class IsEmpty {

	public static boolean isEmptyJobseeker(Jobseeker jobseeker) {
		
		if(jobseeker == null) {
			return true;
		}else if(jobseeker.getBirthDay() == null || jobseeker.getBirthDay().trim().length() == 0) {
			return true;
		}else if(jobseeker.getEmail() == null || jobseeker.getEmail().trim().length() == 0) {
			return true;
		}else if(jobseeker.getFirstName() == null || jobseeker.getFirstName().trim().length() == 0) {
			return true;
		}else if(jobseeker.getIdentityNumber() == null || jobseeker.getIdentityNumber().trim().length() == 0) {
			return true;
		}else if(jobseeker.getLastName() == null || jobseeker.getLastName().trim().length() == 0) {
			return true;
		}else if(jobseeker.getPassword() == null || jobseeker.getPassword().trim().length() == 0) {
			return true;
		}else if(jobseeker.getPaswordRecap() == null || jobseeker.getPaswordRecap().trim().length() == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean isEmptyEmployer(Employer employer) {
		if(employer == null) {
			return true;
		}else if(employer.getCompanyName() == null || employer.getCompanyName().trim().length() == 0) {
			return true;
		}else if(employer.getEmail() == null || employer.getEmail().trim().length() == 0) {
			return true;
		}else if(employer.getPassword() == null || employer.getPassword().trim().length() == 0) {
			return true;
		}else if(employer.getPasswordRecap() == null || employer.getPasswordRecap().trim().length() == 0) {
			return true;
		}else if(employer.getPhoneNumber() == null || employer.getPhoneNumber().trim().length() == 0) {
			return true;
		}else if(employer.getWebAdres() == null || employer.getWebAdres().trim().length() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isEmptyJobPosition(JobPosition jobPosition) {
		if(jobPosition == null) {
			return true;
		}else if(jobPosition.getJobName() == null || jobPosition.getJobName().trim().length() == 0) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isEmptyJobAdvert(JobAdvert jobAdvert) {
		
		if(jobAdvert == null) {
			return true;
		}else if(jobAdvert.getCity() == null || jobAdvert.getCity().trim().length() == 0) {
			return true;
		}else if(jobAdvert.getDeadline() == null || jobAdvert.getDeadline().trim().length() == 0) {
			return true;
		}else if(jobAdvert.getRelaeseDate() == null || jobAdvert.getRelaeseDate().trim().length() == 0) {
			return true;
		}else if(jobAdvert.getJobDescription() == null || jobAdvert.getJobDescription().trim().length() == 0) {
			return true;
		}else if(jobAdvert.getOpenPositionNumber() < 0) {
			return true;
		}else if(jobAdvert.getJobAdvertID() <= 0) {
			return true;
		}else {
			return false;
		}
		
	}
}
