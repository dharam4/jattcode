
//Author : Ankush Kumar
//Reviewer : Navjeevan Kaur
//Mediator : Dharamveer Singh

package library.fixbook;
import library.entities.Book;
import library.entities.Library;

//public class fIX_bOOK_cONTROL 
public class fixBookControl {					//fIX_bOOK_cONTROL changed to fixBookControl
	
	//private FixBookUI Ui;
	private FixBookUI ui;
	//private enum CoNtRoL_StAtE { INITIALISED, READY, FIXING };		//CoNtRoL_StAtE changed to ControlState
	private enum ControlState { INITIALISED, READY, FIXING };
	//private CoNtRoL_StAtE StAtE;
	private ControlState state;
	
	//private Library LiBrArY;
	private Library library;
	//private Book CuRrEnT_BoOk;
	private Book currentBook;				// CuRrEnT_BoOk; changed to currentBook


	//public fIX_bOOK_cONTROL() 
	public fixBookControl() {
		//this.LiBrArY = Library.GeTiNsTaNcE();
		this.library = library.getInstance();
		//StAtE = CoNtRoL_StAtE.INITIALISED;
		state = ControlState.INITIALISED;
	}
	
	
	//public void SeT_Ui(FixBookUI ui) 
	public void setUi(FixBookUi ui) {			//public void SeT_Ui(FixBookUI ui)  changed to public void setUi(FixBookUi ui
		//if (!StAtE.equals(CoNtRoL_StAtE.INITIALISED))
		if (!state.equals(ControlState.INITIALISED))
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			
		//this.Ui = ui;
		this.ui = ui;
		//ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		ui.setState(FixBookUI.uiState.READY);
		//StAtE = CoNtRoL_StAtE.READY;
		state = ControlState.READY;				//StAtE = CoNtRoL_StAtE.READY; changed to state = ControlState.READY;
	}


	//public void BoOk_ScAnNeD(int BoOkId) 
	public void bookScanned(int bookId) {
		//if (!StAtE.equals(CoNtRoL_StAtE.READY))
		if (!state.equals(ControlState.READY))
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			
		//CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);
		currentBook = library.getBook(bookId);			//CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId); changed to currentBook = library.getBook(bookId);
		
		//if (CuRrEnT_BoOk == null) 
		if (currentBook == null) {
			//Ui.dIsPlAy("Invalid bookId");
			ui.display("Invalid bookId");			//Ui.dIsPlAy("Invalid bookId"); changed to ui.display("Invalid bookId");
			return;
		}
		//if (!CuRrEnT_BoOk.iS_DaMaGeD()) 
		if (!currentBook.isDamaged()) {				//if (!CuRrEnT_BoOk.iS_DaMaGeD())  changed to if (!currentBook.isDamaged())
			//Ui.dIsPlAy("Book has not been damaged");
			ui.display("Book has not been damaged");
			return;
		}
		Ui.dIsPlAy(CuRrEnT_BoOk.toString());
		Ui.SeT_StAtE(FixBookUI.uI_sTaTe.FIXING);
		StAtE = CoNtRoL_StAtE.FIXING;		
	}


	public void FiX_BoOk(boolean mUsT_FiX) {
		if (!StAtE.equals(CoNtRoL_StAtE.FIXING)) 
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
			
		if (mUsT_FiX) 
			LiBrArY.RePaIr_BoOk(CuRrEnT_BoOk);
		
		CuRrEnT_BoOk = null;
		Ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		StAtE = CoNtRoL_StAtE.READY;		
	}

	
	public void SCannING_COMplete() {
		if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			
		Ui.SeT_StAtE(FixBookUI.uI_sTaTe.COMPLETED);		
	}

}
