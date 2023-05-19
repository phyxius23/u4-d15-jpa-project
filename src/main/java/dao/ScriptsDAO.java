package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;
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

	// Save
	public void save(Script s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
	}

	// DELETE
	public void delete(long ISBN) {
		Script found = em.find(Script.class, ISBN);

		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Script con ISBN " + ISBN + " è stato eliminato!");
		}
	}

	// GET BY ISBN
	public Script getById(long id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}

}
