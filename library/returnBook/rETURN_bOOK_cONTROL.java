package library.returnBook;
import library.entities.Book;
import library.entities.Library;
import library.entities.Loan;

//public class rETURN_bOOK_cONTROL {
publice class returnBookControl {

	private ReturnBookUI Ui;
	//private enum cOnTrOl_sTaTe { INITIALISED, READY, INSPECTING };
	private enum controlState { INITIALISED, READY, INSPECTING };
	//private cOnTrOl_sTaTe sTaTe;
	private controlState state;
	
	//private Library lIbRaRy;
	private library Library;
	//private Loan CurrENT_loan;
	private Loan currentLoan;
	

	//public rETURN_bOOK_cONTROL() {
	public returnBookControl(){
		//this.lIbRaRy = Library.GeTiNsTaNcE();
		this.library + library.getIntance(); 
		//sTaTe = cOnTrOl_sTaTe.INITIALISED;
		state = Controlstate.INITITALISED;
	}
	
	
	//public void sEt_uI(ReturnBookUI uI) {
	public void setUI(ReturnBookUI UI) {
		//if (!sTaTe.equals(cOnTrOl_sTaTe.INITIALISED)) 
		if (!state.equals(controlState.INITIALISED)) 
			//throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
			throw new runtimeException("ReturnBookControl: cannot call setUI expect in INITIALISED state");
		this.Ui = uI;
		//uI.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		UI.setState(ReturnBookUI.uiState.READY);
		//sTaTe = cOnTrOl_sTaTe.READY;
		state = ControlState.READY;
	}


	//public void bOoK_sCaNnEd(int bOoK_iD) {
	public void booksScanned(int bookId) {
		//if (!sTaTe.equals(cOnTrOl_sTaTe.READY))
	         if (!state.equals(ControlState.READY))
			throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
			 
		//Book cUrReNt_bOoK = lIbRaRy.gEt_BoOk(bOoK_iD);
		currentBook = library.getBook(bookId);	
		
		//if (cUrReNt_bOoK == null) {
		if (currentBook == null) {
			//Ui.DiSpLaY("Invalid Book Id");
			ui.display("Invalid bookId");
			return;
		}
		//if (!cUrReNt_bOoK.iS_On_LoAn()) {
		if (!currentBook. isOnLoan()) {
			//Ui.DiSpLaY("Book has not been borrowed");
			ui.display("Book has not been borrowed");
			return;
		}		
		//CurrENT_loan = lIbRaRy.GeT_LoAn_By_BoOkId(bOoK_iD);	
		currentLoan = library.getLoanbuBookId(boonId);
		//double Over_Due_Fine = 0.0;
		double overdueFine = 0.0;
		//if (CurrENT_loan.Is_OvEr_DuE()) 
		if (currentLoan.isOverdue())
			//Over_Due_Fine = lIbRaRy.CaLcUlAtE_OvEr_DuE_FiNe(CurrENT_loan);
			overdueFine = library.calculateOverdueFine(currentLoan);
		
		//Ui.DiSpLaY("Inspecting");
		ui.display("Inspecting");
		//Ui.DiSpLaY(cUrReNt_bOoK.toString());
		ui.display(currentBook.toString());
		//Ui.DiSpLaY(CurrENT_loan.toString());
		ui.display(currentLoan.toString());
		
		
		//if (CurrENT_loan.Is_OvEr_DuE()) 
		if (currentLoan.isOverdue());
			//Ui.DiSpLaY(String.format("\nOverdue fine : $%.2f", Over_Due_Fine));
		         ui.display(String.format("\nOverdue fine : $%.2f", overdueFine));
		
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.INSPECTING);
		sTaTe = cOnTrOl_sTaTe.INSPECTING;		
	}


	public void sCaNnInG_cOmPlEtE() {
		if (!sTaTe.equals(cOnTrOl_sTaTe.READY)) 
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
			
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.COMPLETED);		
	}


	public void dIsChArGe_lOaN(boolean iS_dAmAgEd) {
		if (!sTaTe.equals(cOnTrOl_sTaTe.INSPECTING)) 
			throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
		
		lIbRaRy.DiScHaRgE_LoAn(CurrENT_loan, iS_dAmAgEd);
		CurrENT_loan = null;
		Ui.sEt_sTaTe(ReturnBookUI.uI_sTaTe.READY);
		sTaTe = cOnTrOl_sTaTe.READY;				
	}


}
