package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerWithJobAdvert {

	private String companyName;
	private String jobPosition;
	private int openPositionNumber;
	private String relaeseDate;
	private String deadline;
}
