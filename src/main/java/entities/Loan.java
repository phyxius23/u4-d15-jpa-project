package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "loans")
@NamedQuery(name = "searchOnLoan", query = "SELECT l.loanScript FROM Loan l JOIN l.users lu WHERE lu.cardNumber = :cardNumber AND l.loanEndDate is NULL")
@NamedQuery(name = "searchExpiredLoan", query = "SELECT l.loanScript FROM Loan l WHERE l.defaultLoanEndDate < CURRENT_DATE AND l.loanEndDate IS NULL")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Loan {

	// Attributo
	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "script_cardnumber")
	private User users;

	@ManyToOne
	@JoinColumn(name = "script_id")
	private Script loanScript;

	private LocalDate loanStartDate;
	private LocalDate defaultLoanEndDate;
	private LocalDate loanEndDate;

	// Costruttore
	public Loan(User users, Script loanScript, LocalDate loanStartDate, LocalDate defaultLoanEndDate,
			LocalDate loanEndDate) {
		this.users = users;
		this.loanScript = loanScript;
		this.loanStartDate = loanStartDate;
		this.defaultLoanEndDate = loanStartDate.plusDays(30);
		this.loanEndDate = loanEndDate;
	}

}
