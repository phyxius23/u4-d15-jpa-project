package dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Book;
import entities.Script;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScriptsDAO {

	// Attributo
	private final EntityManager em;

	// Costruttore
	public ScriptsDAO(EntityManager em) {
		this.em = em;
	}

	// SAVE
	public void save(Script s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
		log.info("Script salvato.");
	}

	// DELETE
	public void delete(UUID ISBN) {
		Script found = em.find(Script.class, ISBN);

		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Script con ISBN " + ISBN + " è stato eliminato!");
		}
	}

	// SEARCH BY ISBN - (GET BY ISBN)
	public Script getByISBN(UUID ISBN) {
		TypedQuery<Script> query = em.createNamedQuery("searchByISBN", Script.class);
		query.setParameter("ISBN", ISBN);
		return query.getSingleResult();
	}

	// SEARCH BY YEAR - (GET BY YEAR)
	public List<Script> getByYear(int publicationYear) {
		TypedQuery<Script> query = em.createNamedQuery("searchByYear", Script.class);
		query.setParameter("publicationYear", publicationYear);
		return query.getResultList();
	}

	// SEARCH BY TITLE - (GET BY TITLE)
	public Script getByTitle(String title) {
		TypedQuery<Script> query = em.createNamedQuery("searchByTitle", Script.class);
		query.setParameter("title", title);
		return query.getSingleResult();
	}

	// SEARCH BY AUTHOR - (GET BY AUTHOR)
	public List<Book> getByAuthor(String author) {
		TypedQuery<Book> query = em.createNamedQuery("searchByAuthor", Book.class);
		query.setParameter("author", author);
		return query.getResultList();
	}

	//REFRESH
	public void refresh(UUID ISBN) {
		Script found = em.find(Script.class, ISBN);
		em.refresh(found);
		System.out.println("Script portato ai valori iniziali dopo il refresh: " + found);
	}

}
