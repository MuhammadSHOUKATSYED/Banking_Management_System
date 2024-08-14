package assignment_1;
import java.time.LocalDate;
import java.util.*;
public class Controller {
	
	//Controller Class responsible for our data flow
	
	Bank bank=new Bank();
	
	Account account = new SavingAccount();
	
	List<Account> acc= bank.getAcc();
	
	public void createAccount(String accId,String name, String univd, String program, String course, String address, String pnum, LocalDate dateCreated, Double deposit, int accnum, int pin, String acctype, String status) {
		bank.createAccount(accId,name,univd,program,course,address,pnum,dateCreated,deposit,accnum,pin,acctype,status);
	}			
	
	public void openjointAccount(String accId,String name1, String id1, String progm1, String cr1, String addr1, String pn1, String name2, String id2, String progm2, String cr2, String addr2, String pn2, LocalDate dateCreated,double depo,int accn, int pi, String acctype, String status){
		bank.openjointAccount(accId,name1,id1,progm1,cr1,addr1,pn1,name2,id2,progm2,cr2,addr2,pn2,dateCreated,depo,accn,pi,acctype,status);
	}
	
	public String checkInfo(int accpi) {
		return bank.checkInfo(accpi);
	}
	public boolean accountFound(int pi) {
		return bank.accountFound(pi);
	}
	public boolean closeAccount(int pi) {
		return bank.closeAccount(pi);
	}
	public double checkBalance(int accpn) {
		return account.checkBalance(acc,accpn);
	}
	public boolean depositAmount(int accpn,double amount) {
		return account.depositAmount(acc, accpn,amount);
	}
	public boolean withdrawAmount(int accpn,double amount) {
		return account.withdrawAmount(acc,accpn,amount);
	}
	public boolean transferAmount(int pi,int accnu,double amunt) {
		return account.transferAmount(pi,acc,accnu,amunt);
	}
	public String printStatement(String accId) {
		return account.printStatement(accId, acc);
	}
	public boolean reactiveDormantaccount(int acpin,double am) {
		return account.reactiveDormantaccount(acc,acpin,am);
	}
}