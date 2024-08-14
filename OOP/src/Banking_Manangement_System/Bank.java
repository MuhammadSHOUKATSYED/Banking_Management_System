package assignment_1;
import java.time.LocalDate;
import java.util.*;
public class Bank {
	List<Account> acc=new ArrayList<Account>();
	List<Student> students=new ArrayList<Student>();
	public Bank() {}
	
public List<Account> getAcc() {
		return acc;
	}
	public void setAcc(List<Account> acc) {
		this.acc = acc;
	}
public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}		
	
public void createAccount(String accId,String name, String uid, String program, String course, String address, String pnum, LocalDate dateCreated, Double deposit, int accnum, int pin, String acctype, String status) {
	if(acctype.equalsIgnoreCase("Saving")) {
    	acc.add(new SavingAccount(accId,dateCreated,deposit,accnum,pin,acctype,status));	
    }
    if(acctype.equalsIgnoreCase("Current")) {
    	String currType="Single";
    	acc.add(new CurrentAccount(accId,dateCreated,deposit,accnum,pin,acctype,status,currType));
    }
    students.add(new Student(name,uid,program,course,address,pnum,acc));
}

public void openjointAccount(String accId,String nam1, String id1, String progm1, String cr1, String addr1, String pn1, String nam2, String id2, String progm2, String cr2, String addr2, String pn2,LocalDate dateCreated,double depo,int accn, int pi,String acctype, String status) {
	String currType="Joint";
	acc.add(new CurrentAccount(accId,dateCreated,depo,accn,pi,acctype,status,currType));
	students.add(new Student(nam1,id1,progm1,cr1,addr1,pn1,acc));
	students.add(new Student(nam2,id2,progm1,cr2,addr2,pn2,acc));
}

public String checkInfo(int accpi) {
	String check="";
	for(int x=0;x<acc.size();x++){
		if(acc.get(x).getPin()==accpi) {
		check=check+acc.get(x).toString();
		}
		}
	return check;
	}
public boolean accountFound(int pi) {
	for(int x=0;x<acc.size();x++){
		if(acc.get(x).getPin()==pi) {
		 return true;
		}
		}
	return false;
}
public boolean closeAccount(int pi) {
	for(int x=0;x<acc.size();x++){
		if(acc.get(x).getPin()==pi) {
		acc.remove(x);
		return true;
		}
		}
	return false;
}
}