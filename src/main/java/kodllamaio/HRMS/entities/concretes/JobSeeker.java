package kodllamaio.HRMS.entities.concretes;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_seekers")
public class JobSeeker extends User{
	@Nonnull @NotBlank(message="Boş bırakılamaz!")
	private String firstName;
	@Nonnull @NotBlank(message="Boş bırakılamaz!")
	private String lastName;
	@Nonnull @NotBlank(message="Boş bırakılamaz!")
	private String identityNumber;
	private int birthYear;
}