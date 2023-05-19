package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.LoansDAO;
import dao.ScriptsDAO;
import dao.UsersDAO;
import entities.Book;
import entities.Loan;
import entities.Magazine;
import entities.MagazineType;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		//log.info("Ciao");
		EntityManager em = emf.createEntityManager();

		ScriptsDAO sd = new ScriptsDAO(em);
		UsersDAO ud = new UsersDAO(em);
		LoansDAO ld = new LoansDAO(em);

		// ********** CREAZIONE BOOK **********
		Book book1 = new Book("Yellow diamonds", 2023, 336, "Paolo Roversi", "Thriller");
		Book book2 = new Book("L'impostore", 2023, 288, "Martin Griffin", "Thriller");
		Book book3 = new Book("La setta", 2022, 768, "Camilla Läckberg", "Giallo");
		Book book4 = new Book("La caccia", 2022, 384, "Will Dean", "Giallo");
		Book book5 = new Book("Fairy Tale", 2022, 677, "Stephen King", "Horror");
		Book book6 = new Book("Black phone. Mai parlare con gli sconosciuti", 2022, 393, "Joe Hill", "Horror");

		// **********  CREAZIONE MAGAZINE  **********
		Magazine magazine1 = new Magazine("National Geographic", 1888, 110, MagazineType.MONTHLY);
		Magazine magazine2 = new Magazine("Settimana Enigmistica", 1932, 60, MagazineType.WEEKLY);
		Magazine magazine3 = new Magazine("Focus", 1992, 105, MagazineType.MONTHLY);
		Magazine magazine4 = new Magazine("Panorama", 1962, 85, MagazineType.WEEKLY);
		Magazine magazine5 = new Magazine("Scienza & Politica", 1989, 164, MagazineType.HALFYEARLY);
		Magazine magazine6 = new Magazine("ArtApp", 2009, 145, MagazineType.HALFYEARLY);

		// **********  CREAZIONE USERS  **********
		//		User user1 = new User("Roberto", "Baggio", "1966-02-18");
		//		User user2 = new User("Gregorio", "Lillovich", "1976-04-13");
		//		User user3 = new User("Gino", "Verdi", "1987-07-04");
		//		User user4 = new User("Levante", "Bianchi", "2013-09-23");
		//		User user5 = new User("Selvaggia", "Vianello", "2001-11-08");
		//		User user6 = new User("Lucia", "Rossi", "2010-05-25");

		// **********  CREAZIONE LOANS  **********
		Loan loan1 = new Loan();
		Loan loan2 = new Loan();
		Loan loan3 = new Loan();
		Loan loan4 = new Loan();
		Loan loan5 = new Loan();
		Loan loan6 = new Loan();

		em.close();
		emf.close();
	}

}
