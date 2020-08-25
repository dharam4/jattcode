
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
		if (!StAtE.equals(CoNtRoL_StAtE.INITIALISED)) 
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			
		this.Ui = ui;
		ui.SeT_StAtE(FixBookUI.uI_sTaTe.READY);
		StAtE = CoNtRoL_StAtE.READY;		
	}


	public void BoOk_ScAnNeD(int BoOkId) {
		if (!StAtE.equals(CoNtRoL_StAtE.READY)) 
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			
		CuRrEnT_BoOk = LiBrArY.gEt_BoOk(BoOkId);
		
		if (CuRrEnT_BoOk == null) {
			Ui.dIsPlAy("Invalid bookId");
			return;
		}
		if (!CuRrEnT_BoOk.iS_DaMaGeD()) {
			Ui.dIsPlAy("Book has not been damaged");
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
