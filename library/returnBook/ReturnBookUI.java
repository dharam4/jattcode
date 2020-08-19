package library.returnBook;
import java.util.Scanner;


public class ReturnBookUI {

	//public static enum uI_sTaTe { INITIALISED, READY, INSPECTING, COMPLETED };
	//public static enum ui_state { INITALISD, READY, INSPECTING, COMPLETED};
	public static enum UiState { INITALISD, READY, INSPECTING, COMPLETED};    //ui_state changed to UiState  : Reviewer : Ankush

	//private rETURN_bOOK_cONTROL CoNtRoL;
	//private return_book control;
	private ReturnBookControl control;    //return_book control changed to ReturnBookControl control:   by :REV : Ankush
	//private Scanner iNpUt;
	private Scanner input;
	//private uI_sTaTe StATe;
	private UiState state;

	
	//public ReturnBookUI(rETURN_bOOK_cONTROL cOnTrOL) {
	//public ReturnBookui(return_book_control control) {
	public ReturnBookUi(ReturnBookControl control)     //return_book_control control) changed to ReturnBookControl control  by REV: Ankush
		//this.CoNtRoL = cOnTrOL;
		this.control = control;
		//iNpUt = new Scanner(System.in);
		input = new Scanner(System.in);
		//StATe = uI_sTaTe.INITIALISED;
		//State = ui-state.INITIALISED;
		state = UiState.INITIALISED;  //State = ui-state.INITIALISED changed to state = UiState.INITIALISED by Rev: Ankush
		//cOnTrOL.sEt_uI(this);
		//control.set_ui(this);
		control.setUi(this);   //control.set_ui(this) changed to control.setUi(this) by Rev: Ankush
	}


	//public void RuN() {
        public void Run() {
		//oUtPuT("Return Book Use Case UI\n");
		output("Returnbook use case ui\n")
		
		while (true) {
			
			//switch (StATe) {
			switch (state) {
			
			case INITIALISED:
				break;
				
			case READY:
				//String BoOk_InPuT_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				String bookinputstring = input("Scan book (<enter> completes): ");
				if (BoOk_InPuT_StRiNg.length() == 0) 
					CoNtRoL.sCaNnInG_cOmPlEtE();
				
				else {
					try {
						int Book_Id = Integer.valueOf(BoOk_InPuT_StRiNg).intValue();
						CoNtRoL.bOoK_sCaNnEd(Book_Id);
					}
					catch (NumberFormatException e) {
						oUtPuT("Invalid bookId");
					}					
				}
				break;				
				
			case INSPECTING:
				String AnS = iNpUt("Is book damaged? (Y/N): ");
				boolean Is_DAmAgEd = false;
				if (AnS.toUpperCase().equals("Y")) 					
					Is_DAmAgEd = true;
				
				CoNtRoL.dIsChArGe_lOaN(Is_DAmAgEd);
			
			case COMPLETED:
				oUtPuT("Return processing complete");
				return;
			
			default:
				oUtPuT("Unhandled state");
				throw new RuntimeException("ReturnBookUI : unhandled state :" + StATe);			
			}
		}
	}

	
	private String iNpUt(String PrOmPt) {
		System.out.print(PrOmPt);
		return iNpUt.nextLine();
	}	
		
		
	private void oUtPuT(Object ObJeCt) {
		System.out.println(ObJeCt);
	}
	
			
	public void DiSpLaY(Object object) {
		oUtPuT(object);
	}
	
	public void sEt_sTaTe(uI_sTaTe state) {
		this.StATe = state;
	}

	
}
