// Author - Dharamveer singh
// Mediator- Ankush kumar
// reviewer - Dipanshu kumar


package library.entities;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Book implements Serializable {
	
	//private String tItLe;
	private String title; // tItLe changed into title-  Author
	//private String AuThOr;
	private String author; // AuThOr changed into author -  Author
	//private String CALLNO;
	private String callNo; // CALLNO changed into callNo -  Author
	//private int iD;  
	private int id;  // iD changed into id -  Author
	
	//private enum sTaTe { AVAILABLE, ON_LOAN, DAMAGED, RESERVED };
	private enum State { AVAILABLE, ON_LOAN, DAMAGED, RESERVED }; // sTaTe changed into State -  Author 
	//private sTaTe StAtE;
	private State state ;  // sTaTe and StAtE changed into State state -  Author
	
	public Book(String author, String title, String callNo, int id) {
		//this.AuThOr = author;
		this.author = author; //AuThOr changed into author -  Author
		//this.tItLe = title;
		this.title = title; // tItLe changed into title -  Author
		//this.CALLNO = callNo;
		this.callNo = callNo; // CALLNO changed into callNo -  Author
		//this.iD = id;
		this.id = id; // iD changed into id
		//this.StAtE = sTaTe.AVAILABLE;
		this.state = State.AVAILABLE;// sTaTe changed into State -  Author
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book: ").append(iD).append("\n")
		  .append("  Title:  ").append(tItLe).append("\n")
		  .append("  Author: ").append(AuThOr).append("\n")
		  .append("  CallNo: ").append(CALLNO).append("\n")
		  .append("  State:  ").append(StAtE);
		
		return sb.toString();
	}

	//public Integer gEtId() {
	public Integer getId() { //gEtId  changed into getId -  Author
		//return iD;
		return id; // iD  changed into id -  Author
	}

	//public String gEtTiTlE() {
	public String getTitle() { // gEtTiTlE changed into getTitle-  Author
		//return tItLe;
		return title; // tItLe changed into title-  Author
	}


	
	//public boolean iS_AvAiLaBlE() {
	public boolean isAvailable() { // iS_AvAiLaBlE changed into isAvailable -  Author
		//-return StAtE == sTaTe.AVAILABLE;
		return state == State.AVAILABLE;  // sTaTe changed into State -  Author
	}

	
	//public boolean iS_On_LoAn() {
		//return StAtE == sTaTe.ON_LOAN; 
		public boolean isOnLoan() {             // iS_On_LoAn to isOnLoan -author
		return state == State.ON_LOAN;      // StAtE to state and sTaTe to State
	}

	
	//public boolean iS_DaMaGeD() {
		//return StAtE == sTaTe.DAMAGED;
		public boolean isDamaged() {   // iS_DaMaGeD to isDamaged
		return state == State.DAMAGED; //StAtE to state and sTaTe to State
	}

	
	//public void BoRrOw() {
		//if (StAtE.equals(sTaTe.AVAILABLE)) 
			//StAtE = sTaTe.ON_LOAN;
		
		//else 
			//throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", StAtE));
		
		public void borrow() {  // BoRrOw to borrow -author
		if (state.equals(State.AVAILABLE)) //StAtE to state and sTaTe to State
			state = State.ON_LOAN; //StAtE to state and sTaTe to State
		
		else 
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", state)); //StAtE to state 
		
	}


	/*public void ReTuRn(boolean DaMaGeD) {
		if (StAtE.equals(sTaTe.ON_LOAN)) 
				if (DaMaGeD) 
				StAtE = sTaTe.DAMAGED;
			
			else 
				StAtE = sTaTe.AVAILABLE;
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", StAtE));*/
		
	public void return(boolean damaged) {  // ReTuRn  to return,  DaMaGeD to damaged
		if (state.equals(State.ON_LOAN)) 
			if (damaged)            //DaMaGeD to damaged
				
				state= State.DAMAGED;			//StAtE to state and sTaTe to State
			
			else 
				state = State.AVAILABLE;		//StAtE to state and sTaTe to State
			
		
		else 
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", state)); //StAtE to state 
			
	}

	
	/*public void RePaIr() {
		if (StAtE.equals(sTaTe.DAMAGED)) 
			StAtE = sTaTe.AVAILABLE;
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", StAtE));
		*/
	
	public void repair() {    //RePaIr to repair
		if (state.equals(State.DAMAGED)) //StAtE to state and sTaTe to State
			state = State.AVAILABLE;		//StAtE to state and sTaTe to State
		
		else 
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", state));  	//StAtE to state 
		
	}


}
