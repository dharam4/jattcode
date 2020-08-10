# jattcode
This project is used for educational perpose
+package library;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import library.borrowbook.borrowbookUI;
import library.borrowbook.borrow_book_control;
import library.entities.Book;
import library.entities.Calendar;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;
import library.fixbook.FixBookUI;
import library.fixbook.fIX_book_control;
import library.payfine.PayFineUI;
import library.payfine.pay_fine_control;
import library.returnBook.ReturnBookUI;
import library.returnBook.return_book_control;


public class Main {
	
	private static Scanner IN;
	private static Library LIB;
	private static String MENU;
	private static Calendar CAL;
	private static SimpleDateFormat SDF;
	
	
	private static String Get_menu() {
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
		  
		return sb.tostring();
	}


	public static void main(String[] args) {		
		try {			
			IN = new Scanner(System.in);
			LIB = Library.GeTiNsTaNcE();
			CAL = Calendar.gEtInStAnCe();
			SDF = new Simpledateformat("dd/MM/yyyy");
	
			for (Member m : LIB.list_Members()) {
				output(m);
			}
			output(" ");
			for (Book b : LIB.list_BoOkS()) {
				output(b);
			}
						
			MENU = Get_menu();
			
			boolean e = false;
			
			while (!e) {
				
				output("\n" + SDF.format(CAL.gEt_DaTe()));
				String c = input(MENU);
				
				switch (c.toupercase()) {
				
				case "M": 
					ADD_MEMBER();
					break;
					
				case "LM": 
					LIST_MEMBERS();
					break;
					
				case "B": 
					ADD_BOOK();
					break;
					
				case "LB": 
					LIST_BOOKS();
					break;
					
				case "FB": 
					FIX_BOOKS();
					break;
					
				case "L": 
					BORROW_BOOK();
					break;
					
				case "R": 
					RETURN_BOOK();
					break;
					
				case "LL": 
					LIST_CURRENT_LOANS();
					break;
					
				case "P": 
					PAY_FINES();
					break;
					
				case "T": 
					INCREMENT_DATE();
					break;
					
				case "Q": 
					e = true;
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				Library.Save();
			}			
		} catch (RuntimeException e) {
			output(e);
		}		
		output("\nEnded\n");
	}	

	
	private static void PAY_FINES() {
		new PayfineUI(new pay_fine_control()).Run();		
	}


	private static void LIST_CURRENT_LOANS() {
		output("");
		for (Loan loan : LIB.list_Current_Loans()) {
			output(loan + "\n");
		}		
	}



	private static void LIST_BOOKS() {
		output("");
		for (book book : LIB.list_Books()) {
			output(book + "\n");
		}		
	}



	private static void LIST_MEMBERS() {
		output("");
		for (member member : LIB.list_Members()) {
			output(member + "\n");
		}		
	}



	private static void BORROW_BOOK() {
		new BorrowBookUI(new borrow book control()).RuN();		
	}


	private static void RETURN_BOOK() {
		new ReturnBookUI(new retrun book control()).Run();		
	}


	private static void FIX_BOOKS() {
		new FixBookUI(new fix_book_control()).Run();		
	}


	private static void INCREMENT_DATE() {
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			CAL.incrementDate(days);
			LIB.check_Current_Loans();
			output(SDF.format(CAL.get_Date()));
			
		} catch (NumberFormatException e) {
			 output("\nInvalid number of days\n");
		}
	}


	private static void ADD_BOOK() {
		
		String Author = input("Enter author: ");
		String Title  = input("Enter title: ");
		String Call_Number = input("Enter call number: ");
		Book Book = LIB.add_BoOk(author, title, call_number);
		output("\n" + Book + "\n");
		
	}

	
	private static void ADD_MEMBER() {
		try {
			String Last_Name = input("Enter last name: ");
			String FirsT_Name  = input("Enter first name: ");
			String emaiL_Address = input("Enter email address: ");
			int Phone_Number = Integer.valueOf(input("Enter phone number: ")).intValue();
			Member Member = LIB.add_Member(Last_Name, FirsT_Name, EmaiL_Address, Phone_Number);
			output("\n" + Member + "\n");
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return IN.nextLine();
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
