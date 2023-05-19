package entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scripts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "script_type")
@Getter
@Setter
@NoArgsConstructor
//@ToString
public abstract class Script {

	// Attributi
	@Id
	@GeneratedValue
	private UUID ISBN;
	private String title;
	private int publicationYear;
	private int numberOfPages;

	@OneToMany(mappedBy = "loanScript") // =>
	private Set<Loan> loans;

	// Costruttore
	public Script(String title, int publicationYear, int numberOfPages) {
		this.title = title;
		this.publicationYear = publicationYear;
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Script [ISBN=" + this.ISBN + ", titolo=" + this.title + ", anno di pubblicazione=" + this.publicationYear
				+ ", numero di pagine=" + this.numberOfPages + "]";
	}

}
