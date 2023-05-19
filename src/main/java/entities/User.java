package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

	// Attributi
	@Id
	@GeneratedValue
	private UUID cardNumber; // => poi provare ad implementare una sequence

	private String name;
	private String surname;
	private LocalDate birthday;

	@OneToMany(mappedBy = "users")
	private Set<Loan> loans;

	// Costruttore
	public User(String name, String surname, LocalDate birthday) {
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

}
