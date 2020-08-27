//Author : Ankush Kumar
//Reviewer : Navjeevan Kaur
//Mediator : Dharamveer Singh 
package library.borrowbook;
import java.util.Scanner;


//public class BorrowBookUI 
public class BorrowBookUi {
	
	//public static enum uI_STaTe { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	public static enum uiState { INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };

	//private bORROW_bOOK_cONTROL CoNtRoL;
	private BorrowBookControl control;
	//private Scanner InPuT;
	private Scanner input;				//InPuT changed input
	//private uI_STaTe StaTe;
	private uiState state;				//uI_STaTe StaTe changed to uiState state

	
	//public BorrowBookUI(bORROW_bOOK_cONTROL control) 
	public BorrowBookUi(BorrowBookControl control) {
		//this.CoNtRoL = control;
		this.control = control;			//CoNtRoL changed to control
		//InPuT = new Scanner(System.in);
		input = new Scanner(System.in);		//InPuT changed to input
		//StaTe = uI_STaTe.INITIALISED;
		state = uiState.INITIALISED;
		//control.SeT_Ui(this);
		control.setUi(this);			//control.SeT_Ui(this); changed to control.setUi(this);
	}

	
	//private String iNpUT(String PrOmPt) 
	private String input(String prompt) {
		//System.out.print(PrOmPt);
		System.out.print(prompt);		//System.out.print(PrOmPt); changed to System.out.print(prompt);
		//return InPuT.nextLine();
		return input.nextLine();		//InPuT changed to input
	}	
		
		
	//private void OuTpUt(Object ObJeCt) 
	private void output(Object object) {		//private void OuTpUt(Object ObJeCt) changed to private void output(Object object) 
		//System.out.println(ObJeCt);

		System.out.println(obJeCt);
}
	
			
	//public void SeT_StAtE(uI_STaTe StAtE) 
	public void setState(uiState state) {
		//this.StaTe = StAtE;
		this.state = state;			//this.StaTe = StAtE; changed to this.state = state; 
	}

	
	//public void RuN() 
	public void run() {				//RuN() changed to run() 
		//OuTpUt("Borrow Book Use Case UI\n");
		output("Borrow Book Use Case UI\n");	//OuTpUt changed to output
		
		while (true) {
			
			//switch (StaTe) 
			switch (state) {		////switch (StaTe) changed to state		
			
			case CANCELLED:
				//OuTpUt("Borrowing Cancelled");
				output("Borrowing Cancelled");
				return;

				
			case READY:
				//String MEM_STR = iNpUT("Swipe member card (press <enter> to cancel): ");
				String memStr = input("Swipe member card (press <enter> to cancel): ");

				//if (MEM_STR.length() == 0) 
				if (memStr.length() == 0) {		//if (MEM_STR.length() == 0)  changed to if (memStr.length() == 0)
					//CoNtRoL.CaNcEl();
					control.cancel();		//CoNtRoL.CaNcEl(); changed to control.cancel();
					break;
				}
				try {
					int MeMbEr_Id = Integer.valueOf(MEM_STR).intValue();
					CoNtRoL.SwIpEd(MeMbEr_Id);
				}
				catch (NumberFormatException e) {
					OuTpUt("Invalid Member Id");
				}
				break;

				
			case RESTRICTED:
				iNpUT("Press <any key> to cancel");
				CoNtRoL.CaNcEl();
				break;
			
				
			case SCANNING:
				String BoOk_StRiNg_InPuT = iNpUT("Scan Book (<enter> completes): ");
				if (BoOk_StRiNg_InPuT.length() == 0) {
					CoNtRoL.CoMpLeTe();
					break;
				}
				try {
					int BiD = Integer.valueOf(BoOk_StRiNg_InPuT).intValue();
					CoNtRoL.ScAnNeD(BiD);
					
				} catch (NumberFormatException e) {
					OuTpUt("Invalid Book Id");
				} 
				break;
					
				
			case FINALISING:
				String AnS = iNpUT("Commit loans? (Y/N): ");
				if (AnS.toUpperCase().equals("N")) {
					CoNtRoL.CaNcEl();
					
				} else {
					CoNtRoL.CoMmIt_LoAnS();
					iNpUT("Press <any key> to complete ");
				}
				break;
				
				
			case COMPLETED:
				OuTpUt("Borrowing Completed");
				return;
	
				
			default:
				OuTpUt("Unhandled state");
				throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);			
			}
		}		
	}


	public void DiSpLaY(Object object) {
		OuTpUt(object);		
	}


}
