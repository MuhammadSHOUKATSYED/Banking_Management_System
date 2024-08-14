package assignment_1;
import java.time.LocalDate;
import java.util.*;
public class View {
	 //User Interface Class
	Controller c = new Controller();
	
	public View() {
		generalMenu();
	}
	
	public void generalMenu() {
		char opt;
		do {
		System.out.println("-----SDA-Financials Ltd-----");
		System.out.println("1. Create an Account\n"
				+ "2. Close an Account\n"
				+ "3. Login Account\n"
				+ "4. Exit the System\n");
		System.out.println("Enter your option: (1 - 5 options)");
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		switch(option) {
		case 1:
			System.out.println("What is your Account type:\n"
					+ "1. Saving\n"
					+ "2. Current\n");
			System.out.println("Enter your option: ");
			int type = input.nextInt();
			if(type==1) {
				System.out.println("Enter your Name: ");
				input.nextLine();
				String name = input.nextLine();
				System.out.println("Enter your University ID: (Formate: 20I-2303) ");
				String uid = input.nextLine();
				System.out.println("Enter your Program: (e.g. BSSE)");
				String program = input.nextLine();
				System.out.println("Enter your Course: (must be SDA)");
				String course = input.nextLine();
				System.out.println("Enter your Address: ");
				String address = input.nextLine();
				System.out.println("Enter your Phone Number: ");
				String pnum = input.nextLine();
				System.out.println("Deposit (at least) 100 Rupees: ");
				Double deposit = input.nextDouble();
				System.out.println("Enter your Account Number: ");
				int accnum = input.nextInt();
				System.out.println("Enter your PIN: ");
				int pin = input.nextInt();
				System.out.println("Enter your Account iD: ");
				input.nextLine();
				String accId = input.nextLine();
				LocalDate dateCreated = LocalDate.now();
				String acctype="Saving";
				String status="Active";
				c.createAccount(accId,name,uid,program,course,address,pnum,dateCreated,deposit,accnum,pin,acctype,status);
				System.out.println("-----Account created successfully-----");
			}
			if(type==2) {
				System.out.println("Please Select one option: \n"
						+ "1. Single Account\n"
						+ "2. Joint Account\n");
				System.out.println("Enter your option: ");
				int select = input.nextInt();
				if(select==1) {
					System.out.println("Enter your Name: ");
					input.nextLine();
					String na = input.nextLine();
					System.out.println("Enter your University ID: (Formate: 20I-2303) ");
					String id = input.nextLine();
					System.out.println("Enter your Program: (e.g. BSSE)");
					String prgam = input.nextLine();
					System.out.println("Enter your Course: (must be SDA)");
					String course = input.nextLine();
					System.out.println("Enter your Address: ");
					String addr = input.nextLine();
					System.out.println("Enter your Phone Number: ");
					String phnum = input.nextLine();
					System.out.println("Deposit (at least) 100 Rupees: ");
					Double depos = input.nextDouble();
					System.out.println("Enter your Account Number: ");
					int accn = input.nextInt();
					System.out.println("Enter your PIN: ");
					int pi = input.nextInt();
					System.out.println("Enter your Account iD: ");
					input.nextLine();
					String accId = input.nextLine();
					LocalDate dateCreated = LocalDate.now();
					String accType="Current";
					String status="Active";
					c.createAccount(accId,na,id,prgam,course,addr,phnum,dateCreated,depos,accn,pi,accType,status);
					System.out.println("-----Account created successfully-----");
				}
				else if(select==2) {
					System.out.println("Enter First Person Information: "); //1st Person info
					System.out.println("Enter your Name: ");
					input.nextLine();
					String name1 = input.nextLine();
					System.out.println("Enter your University ID: (Formate: 20I-2303) ");
					String id1 = input.nextLine();
					System.out.println("Enter your Program: (e.g. BSSE)");
					String progm1 = input.nextLine();
					System.out.println("Enter your Course: (must be SDA)");
					String cr1 = input.nextLine();
					System.out.println("Enter your Address: ");
					String addr1 = input.nextLine();
					System.out.println("Enter your Phone Number: ");
					String pn1 = input.nextLine();
					System.out.println("Enter Second Person Information: ");  //2nd Person info
					System.out.println("Enter your Name: ");
					input.nextLine();
					String name2 = input.nextLine();
					System.out.println("Enter your University ID: (Format: 20I-xxxx) ");
					String id2 = input.nextLine();
					System.out.println("Enter your Program: (e.g. BSSE)");
					String progm2 = input.nextLine();
					System.out.println("Enter your Course: (must be SDA)");
					String cr2 = input.nextLine();
					System.out.println("Enter your Address: ");
					String addr2 = input.nextLine();
					System.out.println("Enter your Phone Number: ");
					String pn2 = input.nextLine();
					System.out.println("Deposit (at least) 100 Rupees: ");
					Double depo = input.nextDouble();
					System.out.println("Enter your Account Number: ");
					int accn = input.nextInt();
					System.out.println("Enter your PIN: ");
					int pi = input.nextInt();
					System.out.println("Enter your Account iD: (For joint accounts: formate is 20I-XXXX-20I-XXXX)");
					input.nextLine();
					String accId = input.nextLine();
					LocalDate dateCreated = LocalDate.now();
					String accType="Current";
					String status="Active";
					c.openjointAccount(accId,name1,id1,progm1,cr1,addr1,pn1,name2,id2,progm2,cr2,addr2,pn2,dateCreated,depo,accn,pi,accType,status);
					System.out.println("-----Account created successfully-----");
				}
			else {
					System.out.println("Error: Wrong Input, Please try again.....");
				}
			}
			break;
		case 2:
			System.out.println("Enter your PIN: ");
			int accpi=input.nextInt();
			if(c.accountFound(accpi)==true) {
			if(c.closeAccount(accpi)==true) {
				System.out.println("Account has been deleted succesfully");
			}
			else {
				System.out.println("Error: Account is unable to be deleted");
			}
			}
			else {
				System.out.println("Error: Account not found");
			}
			break;
		case 3:
			System.out.println("Enter your PIN: ");
			int accpn=input.nextInt();
			if(c.accountFound(accpn)==true) {
				extendedMenu(accpn);
			}
			else {
				System.out.println("Error: Account not found");
			}
			break;
		case 4:
			System.out.println("System Exited.....");
			System.exit(0);
			break;
		default:
				System.out.println("Error: Wrong Input, Please try again with a valid Input.....");
		}
		System.out.println("Do you want to go back to the General Menu (Y/N)");
		opt=input.next().charAt(0);
		if(opt=='n' || opt=='N') {
			System.out.println("System Exited.....");
		}
		}while(opt=='y' || opt=='Y');
}
	public void extendedMenu(int accpn) {
		System.out.println("-----Wellcome to your Account-----\n"
				+ "1. Check your Info\n"
				+ "2. Check Balance\n"
				+ "3. Deposit Amount\n"
				+ "4. Withdraw Amount\n"
				+ "5. Transfer Amount\n"
				+ "6. Print Statement\n"
				+ "7. Reactive Dormant Account"
				+ "8. Logout Account\n");
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		switch(option) {
		case 1:
			System.out.println(c.checkInfo(accpn));
			break;
		case 2:
			System.out.println("Total Amount: "+c.checkBalance(accpn));
			break;
		case 3:
			System.out.println("Enter the amount to be deposited: ");
			double amount=input.nextInt();
			if(c.depositAmount(accpn,amount)==true) {
				System.out.println("Amount deposited successsfully.....");
			}
			else {
				System.out.println("Error: Unable to deposit amount");
			}
			break;
		case 4:
			System.out.println("Enter the amount to be withdrawn: ");
			double amout=input.nextDouble();
			if(c.withdrawAmount(accpn,amout)==true){
				System.out.println("Amount withrawn successfully.....");
			}
			else {
				System.out.println("Error: Unable to withdraw amount, your account is dormant");
			}
			break;
		case 5:
			System.out.println("Transfer Amount: ");
			System.out.println("Enter the account number to which you want to transfer amount: " );
			int accnu=input.nextInt();
			System.out.println("Enter the amount that you want to transfer: ");
			double amunt=input.nextDouble();
			if(c.transferAmount(accpn,accnu,amunt)==true) {
				System.out.println("Amount Transferred successfully");
			}
			else {
				System.out.println("Error: Make sure your account is not dormant and account number you are entering is valid");
			}
			break;
		case 6:
			System.out.println("Enter your account ID; (formate: 20I-XXXX )");
			input.nextLine();
			String accid=input.nextLine();
			System.out.println(c.printStatement(accid));
			break;
		case 7:
			System.out.println("Your current balance is: "+c.checkBalance(accpn));
			System.out.println("Enter amount as much as it reaches at least 100 rupees: ");
			double am=input.nextDouble();
			if(c.reactiveDormantaccount(accpn,am)==true) {
				System.out.println("Account Reactivated Successfully.....");
			}
			else {
				System.out.println("Error: Account not activated");
			}
			break;
		case 8:
			System.out.println("ACCOUNT LOGOUT SUCCESSFULLY.....");
			break;
		default:
		 System.out.println("Error: Wrong Input, Please try again with a valid Input.....");
		}
	}
}