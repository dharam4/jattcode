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
		control.setUi(this);						////CoNtRoL.SeT_Ui(this); changed to control.setUi(this);
	}


	public void SeT_StAtE(uI_sTaTe state) {
		this.StAtE = state;
	}

	
	public void RuN() {
		OuTpUt("Fix Book Use Case UI\n");
		
		while (true) {
			
			switch (StAtE) {
			
			case READY:
				String BoOk_EnTrY_StRiNg = iNpUt("Scan Book (<enter> completes): ");
				if (BoOk_EnTrY_StRiNg.length() == 0) 
					CoNtRoL.SCannING_COMplete();
				
				else {
					try {
						int BoOk_Id = Integer.valueOf(BoOk_EnTrY_StRiNg).intValue();
						CoNtRoL.BoOk_ScAnNeD(BoOk_Id);
					}
					catch (NumberFormatException e) {
						OuTpUt("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String AnS = iNpUt("Fix Book? (Y/N) : ");
				boolean FiX = false;
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
