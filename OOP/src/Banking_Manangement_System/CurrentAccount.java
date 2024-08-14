package assignment_1;
import java.time.LocalDate;
import java.util.*;
public class CurrentAccount extends Account {

	private String currType; //Single or Joint Account
	
	
	public CurrentAccount(String accountId, LocalDate dateCreated, double balance, int accountNumber, int pin,
			String type, String status, String currType) {
		super(accountId, dateCreated, balance, accountNumber, pin, type, status);
		this.currType = currType;
	}
	
	public CurrentAccount() {
		super();
	}
	
	public String getCurrType() {
		return currType;
	}

	public void setCurrType(String currType) {
		this.currType = currType;
	}

	@Override
	public boolean withdrawAmount(List<Account> acc, int accpn, double amount) {
		// TODO Auto-generated method stub
		for(int x=0;x<acc.size();x++) {
   			if(acc.get(x).getPin()==accpn && acc.get(x).getBalance()<100) {
   				return false;
   			}
			if(acc.get(x).getPin()==accpn && acc.get(x).getBalance()>=100) {
			acc.get(x).setBalance(acc.get(x).getBalance()-amount);
			LocalDate date = LocalDate.now();
			Account curracc=new CurrentAccount();
			List<TransactionLedger> transacts=curracc.getTransactions();
			transacts.add(new TransactionLedger(acc.get(x).getAccountId(),date,amount,"withdraw"));
			if(acc.get(x).getBalance()<100) {
				acc.get(x).setStatus("Dormant");
			}
			return true;
			}
   			}
   			return false;
	}

	@Override
	public String toString() {
		return super.toString()+"CurrentAccount [currType=" + currType + "]";
	}
}