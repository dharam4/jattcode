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
				String bookInputString = input("Scan book (<enter> completes): ");
				//if (BoOk_InPuT_StRiNg.length() == 0) 
					if (bookInputString.length() ==0)
					//CoNtRoL.sCaNnInG_cOmPlEtE();
					control.scanningComplete();

				
				else {
					try {
						//int Book_Id = Integer.valueOf(BoOk_InPuT_StRiNg).intValue();
						int bookId = Integer.valueOf(bookInputString).intValue();
						 
						//CoNtRoL.bOoK_sCaNnEd(Book_Id);
						control.bookScanned(bookId);
					}
					catch (NumberFormatException e) {
						//oUtPuT("Invalid bookId");
						Output("Invaild bookId");
					}					
				}
				break;				
				
			case INSPECTING:
				//String AnS = iNpUt("Is book damaged? (Y/N): ");
					String ans = input("Is book damage? (Y/N):");
				//boolean Is_DAmAgEd = false;
					boolean isDamage = false;
							  
				//if (AnS.toUpperCase().equals("Y")) 
					if (ans.toUpperCase().equals("Y"))
					//Is_dAmagEd = true;
					isDamage = true;
				
				//CoNtRoL.dIsChArGe_lOaN(Is_DAmAgEd);
				control.dischargeLoan(isDamage);
			
			case COMPLETED:
				//oUtPuT("Return processing complete");
			          Output("Return processing complete");
				return;
			
			default:
				//oUtPuT("Unhandled state");
				Output("Unhandled state")
				//throw new RuntimeException("ReturnBookUI : unhandled state :" + StATe);
				throw new RuntimeException("ReturnBookUI : unhandled state :" + state);				  
			}
		}
	}

	
	//private String iNpUt(String PrOmPt) {
		private string input(String prompt) {
		//System.out.print(PrOmPt);
		Syatem.out.print(promot)
		//return iNpUt.nextLine();
		return input.nextLine();
	}	
		
		
	//private void oUtPuT(Object ObJeCt) {
	private void output(object object) {						  
		//System.out.println(ObJeCt);
		System.out.println(object);
	}
	
			
	//public void DiSpLaY(Object object) {
	public void display(object object)
		//oUtPuT(object);
		output(object)
	}
	
	//public void sEt_sTaTe(uI_sTaTe state);
		public void setState(UiState state);					  
		//this.StATe = state;
		this.state = state;
	}

	
}
