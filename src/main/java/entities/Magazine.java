package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "magazines")
//@DiscriminatorValue("Magazine") // => opzionale
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Magazine extends Script {

	// Attributi
	@Enumerated(EnumType.STRING)
	private MagazineType periodicity;

	// Costruttore
	public Magazine(String title, int publicationYear, int numberOfPages, MagazineType periodicity) {
		super(title, publicationYear, numberOfPages);
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Magazine [Periodicity=" + this.periodicity + "]";
	}

}
