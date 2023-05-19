package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Script;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersDAO {

	// Attributo
	private final EntityManager em;

	// Costruttore
	public UsersDAO(EntityManager em) {
		this.em = em;
	}

	// SAVE
	public void save(Script s) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(s);
		transaction.commit();
		log.info("User salvato!");
	}

}
