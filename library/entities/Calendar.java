// Author  Dharamveer Singh
// Mediator Anksuh Kumar
// Reviewer Dipanshu

package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	//private static Calendar sElF;
	private static Calendar self;  //sElF to self
	//private static java.util.Calendar cAlEnDaR;
	private static java.util.Calendar calendar;  //cAlEnDaR to calnedar
	
	
	private Calendar() {
		
		//cAlEnDaR = java.util.Calendar.getInstance();
		calendar = java.util.Calendar.getInstance();
	}
	
	//public static Calendar gEtInStAnCe() {
	public static Calendar getInstance() {   // gEtInStAnCe  to getInstance
		//if (sElF == null) {  
		if (self == null) {   // sElF to self
			//sElF = new Calendar();
			self = new Calendar();   // sElF to self
		}
		//return sElF; 
		return self; 	 // sElF to self
	}
	
	public void incrementDate(int days) {
		cAlEnDaR.add(java.util.Calendar.DATE, days);		
	}
	
	public synchronized void SeT_DaTe(Date DaTe) {
		try {
			cAlEnDaR.setTime(DaTe);
	        cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public synchronized Date gEt_DaTe() {
		try {
	        cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
	        cAlEnDaR.set(java.util.Calendar.SECOND, 0);  
	        cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
			return cAlEnDaR.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	public synchronized Date gEt_DuE_DaTe(int loanPeriod) {
		Date nOw = gEt_DaTe();
		cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		Date dUeDaTe = cAlEnDaR.getTime();
		cAlEnDaR.setTime(nOw);
		return dUeDaTe;
	}
	
	public synchronized long GeT_DaYs_DiFfErEnCe(Date targetDate) {
		
		long Diff_Millis = gEt_DaTe().getTime() - targetDate.getTime();
	    long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    return Diff_Days;
	}

}
