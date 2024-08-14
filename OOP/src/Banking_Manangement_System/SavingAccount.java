package assignment_1;
import java.time.LocalDate;
import java.util.*;
public class SavingAccount extends Account{

	public SavingAccount(String accountId, LocalDate dateCreated, double balance, int accountNumber, int pin,
			String type, String status) {
		super(accountId, dateCreated, balance, accountNumber, pin, type, status);
		// TODO Auto-generated constructor stub
	}
	
    public SavingAccount() {
    	super();	
    }
    
   	@Override
	public boolean withdrawAmount(List<Account> acc,int accpn, double amount) {
		// TODO Auto-generated method stub
   		for(int x=0;x<acc.size();x++) {
   			if(acc.get(x).getPin()==accpn && acc.get(x).getBalance()<100) {
   				return false;
   			}
			if(acc.get(x).getPin()==accpn && acc.get(x).getBalance()>=100) {
			acc.get(x).setBalance(acc.get(x).getBalance()-(amount)-(0.01*amount));
			LocalDate date = LocalDate.now();
			Account savacc=new SavingAccount();
			List<TransactionLedger> transacts=savacc.getTransactions();
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
		return super.toString();
	}
}