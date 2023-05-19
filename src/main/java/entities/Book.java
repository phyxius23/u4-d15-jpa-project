package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "books")
@DiscriminatorValue("Book") // => opzionale
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Book extends Script {

	// Attributi
	private String author;
	private String literaryGenre;

	// Costruttore
	public Book(String title, int publicationYear, int numberOfPages, String author, String literaryGenre) {
		super(title, publicationYear, numberOfPages);
		this.author = author;
		this.literaryGenre = literaryGenre;
	}

	@Override
	public String toString() {
		return "Book [Author=" + this.author + ", Literary genre=" + this.literaryGenre + "]";
	}

}
