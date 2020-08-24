//Author :  Ankush Kumar
//Reviewer : Navjevan Kaur
//Mediator : Dharamveer Singh

package library.fixbook;
import java.util.Scanner;


public class FixBookUI {

	//public static enum uI_sTaTe { INITIALISED, READY, FIXING, COMPLETED };
	public static enum UiState{ INITIALISED, READY, FIXING, COMPLETED };				//uI_sTaTe changed to UiState

	//private fIX_bOOK_cONTROL CoNtRoL;
	private fixBookControl control;									//private fIX_bOOK_cONTROL CoNtRoL; changed to private fixBookControl control;	
	//private Scanner InPuT;
	private Scanner input;							//InPuT; changed to input
	//private uI_sTaTe StAtE;
	private UiState state;							//private uI_sTaTe StAtE; changed to private UiState state;

	
	//public FixBookUI(fIX_bOOK_cONTROL CoNtRoL) 
	public FixBookUI(fixBookControl control) {
		//this.CoNtRoL = CoNtRoL;					//CoNtRoL changed to control
		this.control = control;
		//InPuT = new Scanner(System.in);
		input = new Scanner(System.in);					//InPuT changed to input
		//StAtE = uI_sTaTe.INITIALISED;
		state = UiState.INITIALISED;					//StAtE = uI_sTaTe.INITIALISED; changed to state = UiState.INITIALISED;	
		//CoNtRoL.SeT_Ui(this);
		control.setUi(this);						//CoNtRoL.SeT_Ui(this); changed to control.setUi(this);
	}


	//public void SeT_StAtE(uI_sTaTe state)
	public void setState(UiState state) {					//SeT_StAtE(uI_sTaTe state) changed to setState(UiState state) 
		//this.StAtE = state;
		this.state = state;						//StAtE changed to state

	}

	
	//public void RuN() {
	public void run() 							//RuN changed to run
		//OuTpUt("Fix Book Use Case UI\n");
		output("Fix Book Use Case UI\n");				//OuTpUt changed to output
		
		while (true) {
			
			//switch (StAtE) 
			switch (state) {					//(StAtE) changed to state 
			
			case READY:
				//String BoOk_EnTrY_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				String bookEntryString = input("Scan Book (<enter> completes): "); 		//BoOk_EnTrY_StRiNg = iNpUt changed to booEntryString = input
				//if (BoOk_EnTrY_StRiNg.length() == 0)
				if (bookEntryString.length() == 0)			//if (BoOk_EnTrY_StRiNg.length() == 0) changed to if (bookEntryString.length() == 0)
					//CoNtRoL.SCannING_COMplete();
					control.scanningComplete();			//CoNtRoL.SCannING_COMplete(); changed to 
				
				else {
					try {
						//int BoOk_Id = Integer.valueOf(BoOk_EnTrY_StRiNg).intValue();
						int bookId = Integer.valueOf(bookEntryString).intValue();
						//CoNtRoL.BoOk_ScAnNeD(BoOk_Id);
						control.bookScanned(bookId);		//CoNtRoL.BoOk_ScAnNeD(BoOk_Id); changed to control.bookScanned(bookId)
					}
					catch (NumberFormatException e) {
						//OuTpUt("Invalid bookId");
						output("Invalid bookId");		//OuTpUt changed to output
					}
				}
				break;	
				
			case FIXING:
				//String AnS = iNpUt("Fix Book? (Y/N) : ");
				String ans = input("Fix Book? (Y/N) : ");	
				//boolean FiX = false;
				boolean fix = false;
				if (AnS.toUpperCase().equals("Y")) 
					FiX = true;
				
				CoNtRoL.FiX_BoOk(FiX);
				break;
								
			case COMPLETED:
				OuTpUt("Fixing process complete");
				return;
			
			default:
				OuTpUt("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
			
			}		
		}
		
	}

	
	private String iNpUt(String prompt) {
		System.out.print(prompt);
		return InPuT.nextLine();
	}	
		
		
	private void OuTpUt(Object object) {
		System.out.println(object);
	}
	

	public void dIsPlAy(Object object) {
		OuTpUt(object);
	}
	
	
}
