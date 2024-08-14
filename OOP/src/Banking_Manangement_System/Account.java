package assignment_1;
import java.time.LocalDate;
import java.util.*;
public abstract class Account{
	
	private String accountId;
	private LocalDate dateCreated;
	private double balance;
	private int accountNumber;
	private int pin; //pin to login to an account
	private String type; //current or saving
	private String status; //active or dormant account
	List<TransactionLedger> transactions = new ArrayList<TransactionLedger>(); //Error was resolved later after submission
	
	public Account(String accountId,LocalDate dateCreated, double balance, int accountNumber, int pin, String type, String status) {
		super();
		this.accountId=accountId;
		this.dateCreated = dateCreated;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.type = type;
		this.status = status;
	}
	
	public Account() {
		
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<TransactionLedger> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionLedger> transactions) {
		this.transactions = transactions;
	}

	public abstract boolean withdrawAmount(List<Account> acc,int accpn, double amount);
		//abstract method, body is in child classes
	
	public double checkBalance(List<Account> acc,int accpn) {
		double balance = 0.0;
		for(int x=0;x<acc.size();x++) {
			if(acc.get(x).getPin()==accpn) {
			balance=balance+acc.get(x).getBalance();
			}
		}
		return balance;
	}
	public boolean depositAmount(List<Account> acc,int accpn, double amount) {
		for(int x=0;x<acc.size();x++) {
			if(acc.get(x).getPin()==accpn) {
			acc.get(x).setBalance(acc.get(x).getBalance()+amount);
			LocalDate date = LocalDate.now();
			 transactions.add(new TransactionLedger(acc.get(x).getAccountId(),date,amount,"deposit"));
			 return true;
			}
		}
		return false;
	}
	public boolean transferAmount(int pi,List<Account> acc,int accnu,double amunt) {   //error was fixed later after submission
		for(int x=0;x<acc.size();x++) {
   			if(acc.get(x).getPin()==pi && acc.get(x).getBalance()<100) {
   				return false;
   			}
			if(acc.get(x).getPin()==pi && acc.get(x).getBalance()>=100) {
				for(int y=0;y<acc.size();y++) {
					if(acc.get(y).getAccountNumber()==accnu) {
						acc.get(y).setBalance(acc.get(y).getBalance()+(amunt));
						LocalDate date = LocalDate.now();
						transactions.add(new TransactionLedger(acc.get(y).getAccountId(),date,amunt,"transfer"));
					}
				}
			acc.get(x).setBalance(acc.get(x).getBalance()-(amunt));
			if(acc.get(x).getBalance()<100) {
				acc.get(x).setStatus("Dormant");
			}
			return true;
			}
   			}
		return false;
	}
	public String printStatement(String accId,List<Account> acc) {
		String transaction="";
				for(int y=0;y<transactions.size();y++) {
					if(transactions.get(y).getAccountId().equalsIgnoreCase(accId)) {
				 transaction=transaction+transactions.get(y).toString();
					}
			}
		return transaction;
}
	public boolean reactiveDormantaccount(List<Account> acc, int acpin, double am) {
		for(int x=0;x<acc.size();x++) {
			if(acc.get(x).getPin()==acpin) {
				acc.get(x).setBalance(acc.get(x).getBalance()+(am));
				return true;  //it was missing, added later after submission
		}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Account [owneruniId=" + accountId + ", dateCreated=" + dateCreated + ", balance=" + balance
				+ ", accountNumber=" + accountNumber + ", pin=" + pin + ", type=" + type + ", status=" + status
				+ ", transactions=" + transactions + "]";
	}
}