package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advert")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
public class JobAdvert {

	@Id
	@Column(name = "job_advert_id")
	private int jobAdvertID;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@ApiModelProperty(hidden = true)
	@Column(name = "city")
	private String city;
	
	@Column(name = "salary_min")
	private double minSalary;
	
	@Column(name = "salary_max")
	private double maxSalary;
	
	@Column(name = "open_position_number")
	private int openPositionNumber;
	
	@Column(name = "deadline")
	private String deadline;
	
	@Column(name = "release_date")
	private String relaeseDate;
	
	@ApiModelProperty(hidden = true)
	@Column(name = "job_activation")
	private String jobActivation;
	
	@ApiModelProperty(hidden = true)
	@Column(name = "job_position")
	private String jobPosition;
	
	@ApiModelProperty(hidden = true)
	@OneToMany(mappedBy = "jobAdvert")
	private List<Employer> employers;
}
