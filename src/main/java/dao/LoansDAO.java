package dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Loan;
import entities.Script;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoansDAO {

	// Attributo
	private final EntityManager em;

	// Costruttore
	public LoansDAO(EntityManager em) {
		this.em = em;
	}

	// SAVE 
	public void save(Loan l) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(l);
		transaction.commit();
		log.info("Prestito salvato.");
	}

	// SEARCH ON LOAN BY CARD NUMBER
	public List<Script> getByCardNumber(UUID cardNumber) {
		TypedQuery<Script> query = em.createNamedQuery("searchOnLoan", Script.class);
		query.setParameter("cardNumber", cardNumber);
		return query.getResultList();
	}

	// SEARCH LOANS EXPIRED BUT NOT RETURNED
	public List<Script> getExpiredLoan() {
		TypedQuery<Script> query = em.createNamedQuery("searchExpiredLoan", Script.class);
		return query.getResultList();
	}
}
