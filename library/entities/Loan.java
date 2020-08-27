// Author Dharamveer singh
// Mediator Ankush Kumar
// Reviewer dipanshu kumar



package library.entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Loan implements Serializable {
	
	//public static enum lOaN_sTaTe { CURRENT, OVER_DUE, DISCHARGED };
	public static enum loanState { CURRENT, OVER_DUE, DISCHARGED };
	
	//private int LoAn_Id;
	private int loanId;
	//private Book BoOk;
	private Book book;
	//private Member MeMbEr;
	private Member member;
	//private Date DaTe;
	private Date date;
	//private lOaN_sTaTe StAtE;
	private LoanState state;

	
	//public Loan(int loanId, Book bOoK, Member mEmBeR, Date DuE_dAtE) {
	public Loan(int loanId, Book booK, Member member, dateDueDate) {
		//this.LoAn_Id = loanId;
		this.loanId = loanId;
		//this.BoOk = bOoK;
		this.book = booK;
		//this.MeMbEr = mEmBeR;
		this.member = member;
		//this.DaTe = DuE_dAtE;
		this.date = dueDate;
		//this.StAtE = lOaN_sTaTe.CURRENT;
		this.state = loanState.CURRENT;
	}

	
	//public void cHeCk_OvEr_DuE() {
	public void checkOverDue() {
		//if (StAtE == lOaN_sTaTe.CURRENT &&
		if (state == loanState.CURRENT &&
			//Calendar.gEtInStAnCe().gEt_DaTe().after(DaTe)) 
		    Calendar.getInstance().getDate().after(date)) 
			//this.StAtE = lOaN_sTaTe.OVER_DUE;		
			this.state = loanState.OVER_DUE;			
		
	}

	
	//public boolean Is_OvEr_DuE() {
	public boolean isOverDue() {
	//return StAtE == lOaN_sTaTe.OVER_DUE;
		return state == loanState.OVER_DUE;
	}

	
	//public Integer GeT_Id() {
	public Integer getId() {
		//return LoAn_Id;
		return loanId;
	}


	//public Date GeT_DuE_DaTe() {
	public Date getDueDate () {
		//return DaTe;
		return date;
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder sb = new StringBuilder();
		//sb.append("Loan:  ").append(LoAn_Id).append("\n")
		sb.append("Loan:  ").append(loanId).append("\n")
 //.append("  Borrower ").append(MeMbEr.GeT_ID()).append(" : ")
		   .append("  Borrower ").append(member.getId()).append(" : ")
//.append(MeMbEr.GeT_LaSt_NaMe()).append(", ").append(MeMbEr.GeT_FiRsT_NaMe()).append("\n")
        	  .append(member.getLastName()).append(", ").append(member.getFirstName()).append("\n")
		  //.append("  Book ").append(BoOk.gEtId()).append(" : " )
		  .append("  Book ").append(book.getId()).append(" : " )
		  //.append(BoOk.gEtTiTlE()).append("\n")
		  .append(book.getTitle()).append("\n")
		  //.append("  DueDate: ").append(sdf.format(DaTe)).append("\n")
		  .append("  DueDate: ").append(sdf.format(date)).append("\n")
		  //.append("  State: ").append(StAtE);	
		  .append("  State: ").append(state);		
		return sb.toString();
	}


	public Member GeT_MeMbEr() {
		return MeMbEr;
	}


	public Book GeT_BoOk() {
		return BoOk;
	}


	public void DiScHaRgE() {
		StAtE = lOaN_sTaTe.DISCHARGED;		
	}

}
