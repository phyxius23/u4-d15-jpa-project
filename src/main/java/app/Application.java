package app;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.LoansDAO;
import dao.ScriptsDAO;
import dao.UsersDAO;
import entities.Book;
import entities.Loan;
import entities.Magazine;
import entities.MagazineType;
import entities.User;
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

		// ********** SAVE BOOK NEL DB **********
		//		sd.save(book1);
		//		sd.save(book2);
		//		sd.save(book3);
		//		sd.save(book4);
		//		sd.save(book5);
		//		sd.save(book6);

		// **********  CREAZIONE MAGAZINE  **********
		Magazine magazine1 = new Magazine("National Geographic", 1888, 110, MagazineType.MONTHLY);
		Magazine magazine2 = new Magazine("Settimana Enigmistica", 1932, 60, MagazineType.WEEKLY);
		Magazine magazine3 = new Magazine("Focus", 1992, 105, MagazineType.MONTHLY);
		Magazine magazine4 = new Magazine("Panorama", 1962, 85, MagazineType.WEEKLY);
		Magazine magazine5 = new Magazine("Scienza & Politica", 1989, 164, MagazineType.HALFYEARLY);
		Magazine magazine6 = new Magazine("ArtApp", 2009, 145, MagazineType.HALFYEARLY);

		// ********** SAVE MAGAZINE NEL DB **********
		//		sd.save(magazine1);
		//		sd.save(magazine2);
		//		sd.save(magazine3);
		//		sd.save(magazine4);
		//		sd.save(magazine5);
		//		sd.save(magazine6);

		// **********  CREAZIONE USERS  **********
		User user1 = new User("Roberto", "Baggio", LocalDate.of(1966, 2, 18));
		User user2 = new User("Gregorio", "Lillovich", LocalDate.of(1976, 4, 13));
		User user3 = new User("Gino", "Verdi", LocalDate.of(1987, 7, 4));
		User user4 = new User("Levante", "Bianchi", LocalDate.of(2013, 9, 23));
		User user5 = new User("Selvaggia", "Vianello", LocalDate.of(2001, 11, 8));
		User user6 = new User("Lucia", "Rossi", LocalDate.of(2010, 5, 25));

		// ********** SAVE USERS NEL DB **********
		//		ud.save(user1);
		//		ud.save(user2);
		//		ud.save(user3);
		//		ud.save(user4);
		//		ud.save(user5);
		//		ud.save(user6);

		// **********  CREAZIONE LOANS  **********
		Loan loan1 = new Loan(user1, magazine5, LocalDate.now(), LocalDate.now(), null);
		Loan loan2 = new Loan(user3, book2, LocalDate.of(2023, 02, 02), LocalDate.of(2023, 02, 02),
				LocalDate.of(2023, 02, 25));
		Loan loan3 = new Loan(user2, magazine4, LocalDate.of(2023, 12, 01), LocalDate.of(20223, 12, 01),
				LocalDate.of(2023, 12, 27));
		Loan loan4 = new Loan(user4, book6, LocalDate.of(2022, 06, 01), LocalDate.of(2022, 06, 01),
				LocalDate.of(2022, 8, 01));
		Loan loan5 = new Loan(user3, magazine3, LocalDate.of(2023, 01, 05), LocalDate.of(2023, 01, 05), null);
		Loan loan6 = new Loan(user6, book1, LocalDate.of(2023, 1, 29), LocalDate.of(2023, 1, 29), null);

		// ********** SAVE LOANS NEL DB **********
		//		ld.save(loan1);
		//		ld.save(loan2);
		//		ld.save(loan3);
		//		ld.save(loan4);
		//		ld.save(loan5);
		//		ld.save(loan6);

		// **********  SEARCH BY TITLE  **********
		log.info("BOOK SEARCH TITLE: " + sd.getByTitle("Fairy").toString());

		// **********  SEARCH BY ISBN  **********
		log.info("SEARCH ISBN: " + sd.getByISBN(UUID.fromString("630ad0e2-68f8-4cf8-9f9a-f504b0a505c8")));

		// **********  SEARCH BY AUTHOR  **********
		log.info("BOOK SEARCH AUTHOR: " + sd.getByAuthor("Paolo Roversi").toString());

		// **********  DELETE BY UUID **********
		//sd.delete("560a36a2-accc-4894-b594-2b1f4395840a"); // => non funziona perchè non riesce a leggere il tipo inserito 
		sd.delete(UUID.fromString("560a36a2-accc-4894-b594-2b1f4395840a"));

		// **********  SEARCH BY YEAR  **********
		log.info("BOOK SEARCH YEAR: " + sd.getByYear(2023).toString());

		// **********  SEARCH EXPIRED LOAN  **********
		log.info("SEARCH EXPIRED LOAN: " + ld.getExpiredLoan().toString());

		// **********  SEARCH ON LOAN  **********
		log.info("SEARCH ON LOAN: " + ld.getByCardNumber(UUID.fromString("8ffeed9c-a358-43bf-9886-55849897fa54")));

		em.close();
		emf.close();
	}

}
