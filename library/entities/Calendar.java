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
		//cAlEnDaR.add(java.util.Calendar.DATE, days);
		calendar.add(java.util.Calendar.DATE, days);		// cAlEnDaR to calendar
	}
	
 	//public synchronized void SeT_DaTe(Date DaTe) {
	public synchronized void setDate(Date date) { 	// SeT_DaTe to setDate , DaTe to date
		try {
			//cAlEnDaR.setTime(DaTe);
			calendar.setTime(date);
	        //cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);  
		clendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        //cAlEnDaR.set(java.util.Calendar.MINUTE, 0);  
		calendar.set(java.util.Calendar.MINUTE, 0);  
	        //cAlEnDaR.set(java.util.Calendar.SECOND, 0);
		calendar.set(java.util.Calendar.SECOND, 0);  
	        //cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		calendar.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	//public synchronized Date gEt_DaTe() {
	public synchronized Date getDate() {   // gEt_DaTe to getDate -  author
		try {
	       // cAlEnDaR.set(java.util.Calendar.HOUR_OF_DAY, 0);
		calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        //cAlEnDaR.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);  
	        //cAlEnDaR.set(java.util.Calendar.SECOND, 0);
		calendar.set(java.util.Calendar.SECOND, 0);  
	        //cAlEnDaR.set(java.util.Calendar.MILLISECOND, 0);
		calendar.set(java.util.Calendar.MILLISECOND, 0);
			//return cAlEnDaR.getTime();
			return calendar.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	//public synchronized Date gEt_DuE_DaTe(int loanPeriod) {
	public synchronized Date getDueDate(int loanPeriod) {
		//Date nOw = gEt_DaTe();
		Date now = getDate();
		//cAlEnDaR.add(java.util.Calendar.DATE, loanPeriod);
		calendar.add(java.util.Calendar.DATE, loanPeriod);
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
