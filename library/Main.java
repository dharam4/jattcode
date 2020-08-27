package library;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import library.borrowbook.BorrowBookUi;                         //import library.borrowbook.BorrowBookUI
import library.borrowbook.BorrowBookControl;                  //import library.borrowbook.bORROW_bOOK_cONTROL
import library.entities.Book;
import library.entities.Calendar;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;
import library.fixbook.FixBookUi;                            //import library.fixbook.FixBookUI
//import library.fixbook.fIX_bOOK_cONTROL;
import library.fixbook.FixBookControl;
//import library.payfine.PayFineUI;
import library.payfine.PayFineUi;
//import library.payfine.pAY_fINE_cONTROL;
import library.payfine.PayFineControl;
//import library.returnBook.ReturnBookUI;
import library.returnBook.ReturnBookUi;
//import library.returnBook.rETURN_bOOK_cONTROL;
import library.returnBook.ReturnBookControl;

public class Main {
	
	private static Scanner in;                //private static Scanner IN
	private static Library lib;               //private static Library LIB
	private static String menu;               //private static String MENU
	private static Calendar cal;              //private static Calendar CAL
	private static SimpleDateFormat sdf;      //private static SimpleDateFormat SDF
	
	
	private static String getMenu()               //private static String Get_menu() 
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nLibrary Main Menu\n\n")
		  .append("  M  : add member\n")
		  .append("  LM : list members\n")
		  .append("\n")
		  .append("  B  : add book\n")
		  .append("  LB : list books\n")
		  .append("  FB : fix books\n")
		  .append("\n")
		  .append("  L  : take out a loan\n")
		  .append("  R  : return a loan\n")
		  .append("  LL : list loans\n")
		  .append("\n")
		  .append("  P  : pay fine\n")
		  .append("\n")
		  .append("  T  : increment date\n")
		  .append("  Q  : quit\n")
		  .append("\n")
		  .append("Choice : ");
		
		  
		return sb.toString();
	}


	public static void main(String[] args) {		
		try {			
			in = new Scanner(System.in);                 //IN = new Scanner(System.in);
			lib = Library.GeTiNsTaNcE();                 //LIB = Library.GeTiNsTaNcE();
			cal = Calendar.gEtInStAnCe();                //CAL = Calendar.gEtInStAnCe();                
			sdf = new SimpleDateFormat("dd/MM/yyyy");     //SDF = new SimpleDateFormat("dd/MM/yyyy");
	
			for (Member m : lib.listMembers())            //for (Member m : LIB.lIsT_MeMbErS())
			{
				output(m);
			}
			output(" ");
			for (Book b : lib.listBooks())               //for (Book b : LIB.lIsT_BoOkS())
			{
				output(b);
			}
						
			MENU = getMenu();                            //MENU = Get_menu()
			
			boolean e = false;
			
			while (!e) {
				
				output("\n" + sdf.format(cal.getDate()));         //output("\n" + SDF.format(CAL.gEt_DaTe()));
				String c = input(MENU);
				
				switch (c.toUpperCase()) {
				
				case "M": 
					addMember();             //ADD_MEMBER()
					break;
					
				case "LM": 
					listMembers();           //LIST_MEMBERS()
					break;
					
				case "B": 
					ADD_BOOK();             //ADD_BOOK();
					break;
					
				case "LB": 
					listBooks();           //LIST_BOOKS()
					break;
					
				case "FB": 
					fixBooks();            //FIX_BOOKS()
					break;
					
				case "L": 
					borrowBook();         //BORROW_BOOK()
					break;
					
				case "R": 
					returnBook();         //RETURN_BOOK()
					break;
					
				case "LL": 
					listCurrentLoans();      //LIST_CURRENT_LOANS()
					break;
					
				case "P": 
					payFines();              //PAY_FINES()
					break;
					
				case "T": 
					incrementDate();         //INCREMENT_DATE()
					break;
					
				case "Q": 
					e = true;
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				Library.save();                          //Library.SaVe()
			}			
		} catch (RuntimeException e) {
			output(e);
		}		
		output("\nEnded\n");
	}	

	
	//private static void PAY_FINES() {
	private static void payFines() {
		//new PayFineUI(new pAY_fINE_cONTROL()).RuN();
		new PayFineUi(new payFineControl()).run();
		
	}


	//private static void LIST_CURRENT_LOANS() {
	private static void listCurrentLoans() {
		output("");
		//for (Loan loan : LIB.lISt_CuRrEnT_LoAnS()) {
		for (Loan loan : lib.listCurrentLoans()) {
			output(loan + "\n");
			
			
		}		
	}



	//private static void LIST_BOOKS() {
	private static void listBooks() {
		output("");
		//for (Book book : LIB.lIsT_BoOkS()) {
		for (Book book : lib.listBooks()) {
			output(book + "\n");
			
			
		}		
	}



	//private static void LIST_MEMBERS() {
	private static void listMembers() {
		output("");
		//for (Member member : LIB.lIsT_MeMbErS()) {
		for (Member member : lib.listMembers()) {
			output(member + "\n");
			
			
		}		
	}



	//private static void BORROW_BOOK() {
		private static void borrowBook() {
		//new BorrowBookUI(new bORROW_bOOK_cONTROL()).RuN();
			new BorrowBookUi(new borrowBookControl()).run();
		
	}


	//private static void RETURN_BOOK() {
	private static void returnBook() {
		//new ReturnBookUI(new rETURN_bOOK_cONTROL()).RuN();
		new ReturnBookUi(new returnBookControl()).run();	
	}


	//private static void FIX_BOOKS() {
	private static void fixBooks() {
		//new FixBookUI(new fIX_bOOK_cONTROL()).RuN();
		new FixBookUi(new fixBookControl()).run();
		
	}


	private static void incrementDate()              //private static void INCREMENT_DATE()
	{
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			cal.incrementDate(days);                 //CAL.incrementDate(days);
			//LIB.cHeCk_CuRrEnT_LoAnS();
			lib.checkCurrentLoans();
			//output(SDF.format(CAL.gEt_DaTe()));
			output(sdf.format(cal.getDate()));
			
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


	private static void addBook()             //private static void ADD_BOOK()
	{
		
		String author = input("Enter author: ");       //String AuThOr = input("Enter author: ");
		//String TiTlE  = input("Enter title: ");
		String title  = input("Enter title: ");
		//String CaLl_NuMbEr = input("Enter call number: ");
		String callNumber = input("Enter call number: ");
		//Book BoOk = LIB.aDd_BoOk(AuThOr, TiTlE, CaLl_NuMbEr);
		Book book = lib.addBook(author, title, callNumber);
		
		output("\n" + book + "\n");                          //output("\n" + BoOk + "\n");
		
		
	}

	
	private static void addMember()                //private static void ADD_MEMBER()
	{
		try {
			//String LaSt_NaMe = input("Enter last name: ");
			String lastName = input("Enter last name: ");
			//String FiRsT_NaMe  = input("Enter first name: ");
			String firstName  = input("Enter first name: ");
			//String EmAiL_AdDrEsS = input("Enter email address: ");
			String emailAddress = input("Enter email address: ");
			
			
			//int PhOnE_NuMbEr = Integer.valueOf(input("Enter phone number: ")).intValue();
			int phoneNumber = Integer.valueOf(input("Enter phone number: ")).intValue();
			//Member MeMbEr = LIB.aDd_MeMbEr(LaSt_NaMe, FiRsT_NaMe, EmAiL_AdDrEsS, PhOnE_NuMbEr);
			Member member = lib.addNumber(lastName, firstName, emailAddress, phoneNumber);
			//output("\n" + MeMbEr + "\n");
			output("\n" + member + "\n");
			
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return in.nextLine();                          //return IN.nextLine();
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
