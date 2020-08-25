package library.payfine;
import library.entities.Library;
import library.entities.Member;

public class PayFineControl {                          // pAY_fINE_cONTROL
	
	private PayFineUi ui;
	private enum ControlState                     //cOnTrOl_sTaTe
	private ControlState state;                  // cOnTrOl_sTaTe StAtE
	
	private Library library;                     //LiBrArY
	private Member member;                      //MeMbEr


	public PayFineControl() {                          //pAY_fINE_cONTROL()
		this.Library = Library.getInstance();     //this.LiBrArY = Library.GeTiNsTaNcE()      
		state = ControlState.INITIALISED;        //StAtE = cOnTrOl_sTaTe.INITIALISED
	}
	
	
	public void setUI(PayFineUi ui) {               //public void SeT_uI(PayFineUI uI)
		if (!state.equals(ControlState.INITIALISED)) {     //(!StAtE.equals(cOnTrOl_sTaTe.INITIALISED))
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		this.ui = ui;                //uI
		ui.setState(PayFineUi.uiState.READY);     //uI.SeT_StAtE(PayFineUI.uI_sTaTe.READY)
		state = ControlState.READY;	           //StAtE = cOnTrOl_sTaTe.READY	
	}


	public void cardSwiped(int memberId) {               //CaRd_sWiPeD(int MeMbEr_Id)
		if (!stste.equals(ControlState.READY))       //(!StAtE.equals(cOnTrOl_sTaTe.READY)) 
			throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
			
		member = library.getMember(memberId);            //MeMbEr = LiBrArY.gEt_MeMbEr(MeMbEr_Id)
		
		if (member == null) {                      //MeMbEr 
			ui.display("Invalid Member Id");        //Ui.DiSplAY
			return;
		}
		Ui.DiSplAY(MeMbEr.toString());
		Ui.SeT_StAtE(PayFineUI.uI_sTaTe.PAYING);
		StAtE = cOnTrOl_sTaTe.PAYING;
	}
	
	
	public void CaNcEl() {
		Ui.SeT_StAtE(PayFineUI.uI_sTaTe.CANCELLED);
		StAtE = cOnTrOl_sTaTe.CANCELLED;
	}


	public double PaY_FiNe(double AmOuNt) {
		if (!StAtE.equals(cOnTrOl_sTaTe.PAYING)) 
			throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
			
		double ChAnGe = MeMbEr.PaY_FiNe(AmOuNt);
		if (ChAnGe > 0) 
			Ui.DiSplAY(String.format("Change: $%.2f", ChAnGe));
		
		Ui.DiSplAY(MeMbEr.toString());
		Ui.SeT_StAtE(PayFineUI.uI_sTaTe.COMPLETED);
		StAtE = cOnTrOl_sTaTe.COMPLETED;
		return ChAnGe;
	}
	


}
