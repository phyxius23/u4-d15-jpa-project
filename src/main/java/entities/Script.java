package entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "scripts")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "searchByISBN", query = "SELECT s FROM Script s WHERE s.ISBN = :ISBN")
@NamedQuery(name = "searchByYear", query = "SELECT s FROM Script s WHERE s.publicationYear = :publicationYear")
@NamedQuery(name = "searchByTitle", query = "SELECT s FROM Script s WHERE s.title LIKE CONCAT('%', :title, '%')")
//@DiscriminatorColumn(name = "script_type")
@Getter
@Setter
@NoArgsConstructor
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
		return "Script [ISBN=" + ISBN + ", titolo=" + title + ", anno di pubblicazione=" + publicationYear
				+ ", numero di pagine=" + numberOfPages + "]";
	}

}
