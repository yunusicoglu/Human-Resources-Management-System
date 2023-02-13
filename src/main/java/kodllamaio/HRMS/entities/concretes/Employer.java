package kodllamaio.HRMS.entities.concretes;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User{

	@Nonnull @NotBlank(message="Boş geçilemez!")
	private String companyName;
	@Nonnull @NotBlank(message="Boş geçilemez!")
	private String webAddress;
	@Nonnull @NotBlank(message="Boş geçilemez!")
	private String phoneNumber;
}
