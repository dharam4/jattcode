// admin- Dharamveer Singh
// mediator - Ankush kumar
// reviewer dipanshu kumar



package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	//private String LaSt_NaMe;
	private String lastName;         //LaSt_NaMe to lastName - author
	//private String FiRsT_NaMe;
	private String firstName;	  // FiRsT_NaMe to firstName -author
	//private String EmAiL_AdDrEsS;
	private String emailAddress;    // EmAiL_AdDrEsS to emailAddress -author
	//private int PhOnE_NuMbEr;
	private int phoneNumber;  // PhOnE_NuMbEr to phoneNumber-author
	// private int MeMbEr_Id;
	private int memberId;  //MeMbEr_Id to memberId -author
	//private double FiNeS_OwInG;
	private double finesOwing;  	//FiNeS_OwInG to private finesOwing -author
	
	// private Map<Integer, Loan> cUrReNt_lOaNs;
	private map<Integer, Loan> currentLoan; 	// Map to map , cUrReNt_lOaNs to currentLoan

	
	//public Member(String lAsT_nAmE, String fIrSt_nAmE, String eMaIl_aDdReSs, int pHoNe_nUmBeR, int mEmBeR_iD) { -author
	public member(String lastName, String FirstName, String emailAdress, int phoneNumber, int memberId) {
		this.lastName = lastName; 	//lAsT_nAmE to lastName  -author
		this.firstName = firstName;	//fIrSt_nAmE to firstName	-author
		this.emailAdress = emailAdress;// eMaIl_aDdReSs to emailAdress	-author
		this.phoneNumber = phoneNumber; //PhOnE_NuMbEr to phoneNumber 	-author
		this.memberId = memberId;	//MeMbEr_Id to memberId	-author
		
		//this.cUrReNt_lOaNs = new HashMap<>();
		this.currentLoan = new HashMap<>();		//cUrReNt_lOaNs to currentLoan -author
	}

	
	/*public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(MeMbEr_Id).append("\n")
		  .append("  Name:  ").append(LaSt_NaMe).append(", ").append(FiRsT_NaMe).append("\n")
		  .append("  Email: ").append(EmAiL_AdDrEsS).append("\n")
		  .append("  Phone: ").append(PhOnE_NuMbEr)
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", FiNeS_OwInG))
		  .append("\n");
		
		for (Loan LoAn : cUrReNt_lOaNs.values()) {
			sb.append(LoAn).append("\n");
		}		  
		return sb.toString();
	}*/
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(memberId).append("\n") //MeMbEr_Id to memberId - author
		  .append("  Name:  ").append(lastName).append(", ").append(FiRsT_NaMe).append("\n")  // FiRsT_NaMe to firstName , //lAsT_nAmE to lastName-author 
		  .append("  Email: ").append(emailAdress).append("\n")  // eMaIl_aDdReSs to emailAdress	-author
		  .append("  Phone: ").append(phoneNumber)  //PhOnE_NuMbEr to phoneNumber 	-author
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", fineOwing)) 	//FiNeS_OwInG to private finesOwing -author
		  .append("\n");
		
		for (Loan loan : currentLoan.values()) {	//Loan to loan ,cUrReNt_lOaNs to currentLoan -author
			sb.append(loan).append("\n");		// Loan to loan  -author
		}		  
		return sb.toString();
	}

	
	/*public int GeT_ID() {
		return MeMbEr_Id;*/
	public int getId() { //	GeT_ID to getId - author
		
		return memberId;	// MeMbEr_Id to memberId
	}

	
	//public List<Loan> GeT_LoAnS() {
	public List<loan> getLoans() { 	// GeT_LoAnS to getLoans, Loan to loan
		
		//return new ArrayList<Loan>(cUrReNt_lOaNs.values());
		return new ArrayList<loan>(currentLoan.values());	// cUrReNt_lOaNs to currentLoan ,Loan to loan - author
	}

	
	//public int gEt_nUmBeR_Of_CuRrEnT_LoAnS() {
	public int getNumberOfCurrentLoans() { 		//gEt_nUmBeR_Of_CuRrEnT_LoAnS to getNumberOfCurrentLoans
		return currentLoans.size();   		// cUrReNt_lOaNs to currentLoan
	}

	
	//public double FiNeS_OwEd() {
	public double fineOwed() { // FiNeS_OwEd to fineOwed
		//return FiNeS_OwInG;
		return finesOwing;
	}

	
	//public void TaKe_OuT_LoAn(Loan lOaN) {
	public void takeOutLoan(Loan loan) {
		
		//if (!cUrReNt_lOaNs.containsKey(lOaN.GeT_Id())) 
		if (!currentLoans.containsKey(loan.getId())) 	//cUrReNt_lOaNs to currentLoans , lOaN.GeT_Id to loan.getId - Author
			currentLoans.put(loan.getId(), loan); 	//cUrReNt_lOaNs to currentLoans , lOaN.GeT_Id to loan.getId - Author
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	//public String GeT_LaSt_NaMe() {
	public String getLastName() {	//GeT_LaSt_NaMe to getLastName - Author
		//return LaSt_NaMe;
		return lastName;		//LaSt_NaMe to lastName -Author
	}

	
	//public String GeT_FiRsT_NaMe() {
	public String getFirstName() { //GeT_FiRsT_NaMe to getFirstName
		//return FiRsT_NaMe;
		return firstName;	//FiRsT_NaMe to firstName
	}


	//public void AdD_FiNe(double fine) {
	public void addFine(double fine) {	// AdD_FiNe to addFine
		//FiNeS_OwInG += fine;
		fineOwing += fine; 	// FiNeS_OwInG to fineOwing
	}
	
	public double PaY_FiNe(double AmOuNt) {
		if (AmOuNt < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (AmOuNt > FiNeS_OwInG) {
			change = AmOuNt - FiNeS_OwInG;
			FiNeS_OwInG = 0;
		}
		else 
			FiNeS_OwInG -= AmOuNt;
		
		return change;
	}


	public void dIsChArGeLoAn(Loan LoAn) {
		if (cUrReNt_lOaNs.containsKey(LoAn.GeT_Id())) 
			cUrReNt_lOaNs.remove(LoAn.GeT_Id());
		
		else 
			throw new RuntimeException("No such loan held by member");
				
	}

}
