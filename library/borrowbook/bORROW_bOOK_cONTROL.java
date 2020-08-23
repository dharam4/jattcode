//Author : Ankush Kumar
//Reviewer : Navjeevan Kaur
//Mediator : Dharamveer Singh
package library.BorrowBook;		//borrowbook;
import java.util.ArrayList;
import java.util.List;

import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;
import library.entities.Member;

public class BorrowBookControl 
	 //public class bORROW_bOOK_cONTROL {
	//private BorrowBookUI uI;     
	private BorrowBookUI ui;   	//uI changed to ui
	
	private Library library;   	//lIbRaRy;
	private Member member;     	//mEmBeR;
	private enum ControlState;  	//CONTROL_STATE { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	private ControlState state;    	//CONTROL_STATE sTaTe;
	
	//private List<Book> pEnDiNg_LiSt; 
	private List<Book> pendingList;    //private List<Book> pEnDiNg_List changed to private List<Book> pendingList
	//private List<Loan> cOmPlEtEd_LiSt;
	private List<Loan> completedList; 	// cOmPlEtEd_LiSt changed to  completedList
	//private Book bOoK;
	private Book book;			//bOok changed to book
	
	//public bORROW_bOOK_cONTROL() 
	public borrowBookControl(){		//bORROW_bOOK_cONTROL() changed to borrowBookControl
		//this.lIbRaRy = Library.GeTiNsTaNcE();
		this.Library = Library.getInstance();  	//this.lIbRaRy = Library.GeTiNsTaNcE(); changed to this.Library = Library.getInstance();
		//sTaTe = CONTROL_STATE.INITIALISED;
		state = =ControlState.INITIALISED;	//sTaTe = CONTROL_STATE.INITIALISED; changed to state = =ControlState.INITIALISED;
	}
	

	//public void SeT_Ui(BorrowBookUI Ui)
	public void setUi(BorrowBookUi ui){		//public void SeT_Ui(BorrowBookUI Ui) changed to public void setUi(BorrowBookUi ui)
		//if (!sTaTe.equals(CONTROL_STATE.INITIALISED)) 
		if (!state.equals(ControlState.INITIALISED)) 	//if (!sTaTe.equals(CONTROL_STATE.INITIALISED)) changed to if (!state.equals(ControlState.INITIALISED)) 
			throw new RuntimeException("BorrowBookControl: cannot call setUI except in INITIALISED state");
			
		//this.uI = Ui;
		this.ui = ui;				//uI and Ui changed to ui
		//Ui.SeT_StAtE(BorrowBookUI.uI_STaTe.READY);
		ui.setState(BorrowBookUi.uiState.READY); 	
		
		//sTaTe = CONTROL_STATE.READY;
		state = ControlState.READY;
	}

		
	//public void SwIpEd(int mEmBeR_Id) 
	public void swipeD(int memberId) {				//SWIpEd and mEmBeR_Id changed to swipeD and memberId
		//if (!sTaTe.equals(CONTROL_STATE.READY))
		if (!state.equals(ControlState.READY)) 			//sTaTe and CONTROL_STATE changed to state and ControlState
			throw new RuntimeException("BorrowBookControl: cannot call cardSwiped except in READY state");
			
		//mEmBeR = lIbRaRy.gEt_MeMbEr(mEmBeR_Id);
		member = Library.getMember(memberId);
		//if (mEmBeR == null) 
		if (member == null)  {					//mEmBeR changed to member
			//uI.DiSpLaY("Invalid memberId");
			ui.display("Invalid memberId"); 		//uI.DiSpLaY changed to ui.display
			return;
		}
		//if (lIbRaRy.cAn_MeMbEr_BoRrOw(mEmBeR)) 
		if (Library.canMemberBorrow(member)) {			//(lIbRaRy.cAn_MeMbEr_BoRrOw(mEmBeR)) changed to  (Library.canMemberBorrow(member))
			//pEnDiNg_LiSt = new ArrayList<>();
			pendingList = new ArrayList<>();		//pEnDiNg_LiSt changed to pendingList
			//uI.SeT_StAtE(BorrowBookUI.uI_STaTe.SCANNING);
			ui.setState(BorrowBookUi.uiState.SCANNING);     
			//sTaTe = CONTROL_STATE.SCANNING;
			state = ControlState.SCANNING			//sTaTe = CONTROL_STATE changed to state = ControlState
		}
		else {
			//uI.DiSpLaY("Member cannot borrow at this time");
			ui.display("Member cannot borrow at this time");
			//uI.SeT_StAtE(BorrowBookUI.uI_STaTe.RESTRICTED); 
			ui.setState(BorrowBookUI.uiState.RESTRICTED); 
		}
	}
	
	
	//public void ScAnNeD(int bOoKiD)
	public void scanned(int bookId) { 				//ScAnNed and bOoKiD changed to scanned and bookId
		//bOoK = null;
		book = null;						//bOok changed to book
		//if (!sTaTe.equals(CONTROL_STATE.SCANNING))
		if (!state.equals(ControlState.SCANNING))		//!sTaTe.equals(CONTROL_STATE changed to state.equals(ControlState
			throw new RuntimeException("BorrowBookControl: cannot call bookScanned except in SCANNING state");
			
		//bOoK = lIbRaRy.gEt_BoOk(bOoKiD);
		booK = Library.getBook(bookId); 			//bOoK = lIbRaRy.gEt_BoOk(bOoKiD) changed to booK = Library.getBook(bookId);
		//if (bOoK == null)
		if (book == null) {					//bOok changed to book
			//uI.DiSpLaY("Invalid bookId");
			ui.display("Invalid bookId");			//uI.DiSpLaY("Invalid bookId"); changed to ui.display("Invalid bookId");
			return;
		}
		//if (!bOoK.iS_AvAiLaBlE())
		if (!book.isAvailable()) {				//book.isAvailable changed to book.isAviable
			uI.DiSpLaY("Book cannot be borrowed");
			return;
		}
		//pEnDiNg_LiSt.add(bOoK);
		pendingList.add(book);					//pEnDiNg_LiSt.add(bOoK) changed to pendingList.add(bOok)
		//for (Book B : pEnDiNg_LiSt)
		for (Book B : pendingList)				//pEnDiNg_LiSt changed to pendingList
			//uI.DiSpLaY(B.toString());
			ui.display(B.toString());			//uI.DiSpLaY(B.toString()); changed to ui.display(B.toString());
		
		//if (lIbRaRy.gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(mEmBeR) - pEnDiNg_LiSt.size() == 0)
		if (Library.getNumberOfLoansRemainingForMember(member) - pendingList.size() == 0) {
			//uI.DiSpLaY("Loan limit reached");
			ui.display("Loan limit reached");			//uI.DiSpLay changed to ui.display
			//CoMpLeTe();
			complete();						//CoMpLeTe changed to complete
		}
	}
	
	
	//public void CoMpLeTe() 
	public void complete {							//CoMpLeTe changed to complete
		//if (pEnDiNg_LiSt.size() == 0)
		if (pendingList.size() == 0)					//(pEnDiNg_LiSt.size() changed to pendingList
			//CaNcEl();
			cancel();						//CaNcEl(); changed to cancel
		
		else {
			//uI.DiSpLaY("\nFinal Borrowing List");
			ui.display("\nFinal Borrowing List");
			//for (Book bOoK : pEnDiNg_LiSt)
			for (Book book : pendingList)
				//uI.DiSpLaY(bOoK.toString());			uI.DiSpLaY(bOoK.toString());  changed to ui.display(book.toString());
				ui.display(book.toString());
			
			//cOmPlEtEd_LiSt = new ArrayList<Loan>();
			completedList = new ArrayList<Loan>();			//cOmPlEtEd_LiSt changed to completedList
			//uI.SeT_StAtE(BorrowBookUI.uI_STaTe.FINALISING);
			ui.setState(BorrowBookUi.uiState.FINALISING);
			//sTaTe = CONTROL_STATE.FINALISING;
			state = ControlState.FINALISING;
		}
	}


	//public void CoMmIt_LoAnS() 					//CoMmIt_LoAnS() changed to commitLoans()
	public void commitLoans() {
		//if (!sTaTe.equals(CONTROL_STATE.FINALISING))
		if (!state.equals(ControlState.FINALISING))		//if (!sTaTe.equals(CONTROL_STATE.FINALISING)) changed to if (!state.equals(ControlState.FINALISING))
			throw new RuntimeException("BorrowBookControl: cannot call commitLoans except in FINALISING state");
			
		//for (Book B : pEnDiNg_LiSt) 
		for (Book B : pendingList) {
			//Loan lOaN = lIbRaRy.iSsUe_LoAn(B, mEmBeR);
			Loan loan = Library.issueLoan(B, member);
			//cOmPlEtEd_LiSt.add(lOaN);			//cOmPlEtEd_LiSt.add(lOaN); changed to completedList.add(loan);
			completedList.add(loan);
		}
		//uI.DiSpLaY("Completed Loan Slip");
		ui.display("Completed Loan Slip");
		//for (Loan LOAN : cOmPlEtEd_LiSt)
		for (Loan loan : completedList)
			//uI.DiSpLaY(LOAN.toString());
			ui.display(loan.toString());
		
		//uI.SeT_StAtE(BorrowBookUI.uI_STaTe.COMPLETED);
		ui.setState(BorrowBookUi.uiState.COMPLETED);
		//sTaTe = CONTROL_STATE.COMPLETED;
		state = ControlState.COMPLETED;
	}

	
	//public void CaNcEl()
	public void cancel() {
		//uI.SeT_StAtE(BorrowBookUI.uI_STaTe.CANCELLED);
		ui.setState(BorrowBookUi.uiState.CANCELLED);
		//sTaTe = CONTROL_STATE.CANCELLED;
		state = ControlState.COMPLETED;
	}
	
	
}
