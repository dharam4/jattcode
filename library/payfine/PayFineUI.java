// Author : Dipanshu Kumar
// Mediator : Navjeevan Kaur 
// Reviewer : Dharamveer Singh

package library.payfine;                               
import java.util.Scanner;


public class PayFineUI {


	public static enum UiState                     //uI_sTaTe { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };

	private PayFineControl control;                //pAY_fINE_cONTROL CoNtRoL
	private Scanner input;
	private UiState state;                         //uI_sTaTe StAtE

	
	public PayFineUi(PayFineControl control)       //PayFineUI(pAY_fINE_cONTROL control){
		this.control = control;                //CoNtRoL
		input = new Scanner(System.in);
		state = UiState.INITIALISED;           //StAtE=uI_sTaTe.INITIALISED
		control.setUi(this);                  //control.SeT_uI(this);
	}
	
	
	public void setState(UiState state)           //SeT_StAtE(uI_sTaTe state){
		this.state = state;                   //this.StAtE = state;
	}


	public void run() {                          //RuN
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (state) {            //StAtE
			
			case READY:
				String memStr = input("Swipe member card (press <enter> to cancel): ");     //Mem_Str
				if (memStr.length() == 0) {       //Mem_Str
					control.cancel();         //CoNtRoL.CaNcEl
					break;
				}
				try {
					int memberId = Integer.valueOf(memStr).intValue();     //Member_ID, Mem_Str
					control.cardSwipe(memberId);                        //CoNtRoL.CaRd_sWiPeD(Member_ID)
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double amount = 0;                                              //AmouNT
				String amtStr = input("Enter amount (<Enter> cancels) : ");     //Amt_Str 
				if (amtStr.length() == 0) {                                    //Amt_Str
					control.cancel();                                      //CoNtRoL.CaNcEl()
				
	
					break;
				}
				try {
					AmouNT = Double.valueOf(Amt_Str).doubleValue();
				}
				catch (NumberFormatException e) {}
				if (AmouNT <= 0) {
					output("Amount must be positive");
					break;
				}
				CoNtRoL.PaY_FiNe(AmouNT);
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}	
			

	public void DiSplAY(Object object) {
		output(object);
	}


}
