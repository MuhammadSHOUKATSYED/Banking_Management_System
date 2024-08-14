package assignment_1;
import java.time.LocalDate;
import java.util.*;
public class TransactionLedger {
	
	private String accountId;
    private LocalDate dateTime;
    private double transactionAmount;
    private String transactionType;
    
	public TransactionLedger(String accountId, LocalDate dateTime, double transactionAmount, String transactionType) {
		super();
		this.accountId = accountId;
		this.dateTime = dateTime;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public LocalDate getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "TransactionLedger [accountId=" + accountId + ", dateTime=" + dateTime + ", transactionAmount="
				+ transactionAmount + ", transactionType=" + transactionType + "]";
	}	
}