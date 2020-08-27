// Author Dharamveer singh
// Mediator Ankush Kumar
// reviewer Dipanshu Kumar

package library.entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Library implements Serializable {
	
	//private static final String lIbRaRyFiLe = "library.obj";
	private static final String libraryFile = "library.obj";
	//private static final int lOaNlImIt = 2;
	private static final int loanLimit = 2;
	private static final int loanPeriod = 2;
	//private static final double FiNe_PeR_DaY = 1.0;
	private static final double FinePerDay = 1.0;
	private static final double maxFinesOwed = 1.0;
	private static final double damageFee = 2.0;
	
	//private static Library SeLf;
	private static Library self;
	//private int bOoK_Id;
	private int bookId;  // bOoK_Id to bookId
	//private int mEmBeR_Id;
	private int memberId;   //mEmBeR_Id to memberId
	//private int lOaN_Id;
	private int loanId; // lOaN_Id to loanId
	//private Date lOaN_DaTe;
	private Date loanDate;   //lOaN_DaTe to loanDate
	
	//private Map<Integer, Book> CaTaLoG;
	private Map<Integer, Book> catalog;	// CaTaLoG to catalog
	//private Map<Integer, Member> MeMbErS;
	private Map<Integer, Member> members;   // MeMbErS to members
	//private Map<Integer, Loan> LoAnS;
	private Map<Integer, Loan> loans;    //LoAnS to  loans
	//private Map<Integer, Loan> CuRrEnT_LoAnS;
	private Map<Integer, Loan> currentLoans;  // CuRrEnT_LoAnS to currentLoans
	//private Map<Integer, Book> DaMaGeD_BoOkS;
	private Map<Integer, Book> damagedBooks;    //DaMaGeD_BoOkS to damagedBooks
	

	private Library() {
		//CaTaLoG = new HashMap<>();
		catalog = new HashMap<>();
		//MeMbErS = new HashMap<>();
		members = new HashMap<>();
		//LoAnS = new HashMap<>();
		loans = new HashMap<>();
		//CuRrEnT_LoAnS = new HashMap<>();
		currentLoans = new HashMap<>();
		//DaMaGeD_BoOkS = new HashMap<>();
		damagedBooks= new HashMap<>();
		//bOoK_Id = 1;
		bookId = 1;
		//mEmBeR_Id = 1;
		memberId = 1;		
		//lOaN_Id = 1;	
		loanId = 1;		
	}

	
	//public static synchronized Library GeTiNsTaNcE() {	
	public static synchronized Library getInstance() {		
		//if (SeLf == null) {
		if (self == null) {
			//Path PATH = Paths.get(lIbRaRyFiLe);			
			Path path = Paths.get(libraryFile);			
			//if (Files.exists(PATH)) {	
			if (Files.exists(path)) {	
				//try (ObjectInputStream LiBrArY_FiLe = new ObjectInputStream(new FileInputStream(lIbRaRyFiLe));) {
				try (ObjectInputStream libraryFile = new ObjectInputStream(new FileInputStream(libraryFile));) {
			    
					//SeLf = (Library) LiBrArY_FiLe.readObject();
					self = (Library) libraryFile.readObject();
					//Calendar.gEtInStAnCe().SeT_DaTe(SeLf.lOaN_DaTe);
					Calendar.getInstance().setDate(self.loanDate);
					//LiBrArY_FiLe.close();
					libraryFile.close();
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			//else SeLf = new Library();
			else self = new Library();
		}
		//return SeLf;
		return self;
	}

	
	//public static synchronized void SaVe() {
	public static synchronized void save() {
		//if (SeLf != null) {
		if (self != null) {
			//SeLf.lOaN_DaTe = Calendar.gEtInStAnCe().gEt_DaTe();
			
			self.loanDate = Calendar.getInstance().getDate();
			//try (ObjectOutputStream LiBrArY_fIlE = new ObjectOutputStream(new FileOutputStream(lIbRaRyFiLe));) {
			try (ObjectOutputStream libraryFile = new ObjectOutputStream(new FileOutputStream(libraryFile));) {
				//LiBrArY_fIlE.writeObject(SeLf);
				libraryFile.writeObject(self);
				//LiBrArY_fIlE.flush();
				libraryFile.flush();    //LiBrArY_fIlE to libraryFile
				//LiBrArY_fIlE.close();	
				libraryFile.close();	
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	
	// public int gEt_BoOkId() {
	public int getBookId() {
		//return bOoK_Id;
		return bookId;
	}
	
	
	//public int gEt_MeMbEr_Id() {
	public int getMemberId() {
		//return mEmBeR_Id;
		return memberId;
	}
	
	
	//private int gEt_NeXt_BoOk_Id() {
	private int getNextBookId() {
		//return bOoK_Id++;
		return bookId++;
	}

	
	//private int gEt_NeXt_MeMbEr_Id() {
	private int getNextMemberId() {
		//return mEmBeR_Id++;
		return memberId++;
	}

	
	//private int gEt_NeXt_LoAn_Id() {
	private int getNextLoanId() {
		//return lOaN_Id++;
		return loanId++;
	}

	
	//public List<Member> lIsT_MeMbErS() {		
	public List<Member> listMembers() {		
		//return new ArrayList<Member>(MeMbErS.values()); 
		return new ArrayList<Member>(members.values()); 
	}


	//public List<Book> lIsT_BoOkS() {		
	public List<Book> listBooks()  {		
		//return new ArrayList<Book>(CaTaLoG.values()); 
		return new ArrayList<Book>(catalog.values()); 
	}


	//public List<Loan> lISt_CuRrEnT_LoAnS() {
	public List<Loan> listCurrentLoans() {
		//return new ArrayList<Loan>(CuRrEnT_LoAnS.values());
		return new ArrayList<Loan>(currentLoans.values());
	}


	//public Member aDd_MeMbEr(String lastName, String firstName, String email, int phoneNo) {		
	public Member addMember(String lastName, String firstName, String email, int phoneNo) {		
		//Member member = new Member(lastName, firstName, email, phoneNo, gEt_NeXt_MeMbEr_Id());
		Member member = new Member(lastName, firstName, email, phoneNo, getNextMemberId());
		//MeMbErS.put(member.GeT_ID(), member);		
		members.put(member.getId(), member);		
		return member;
	}

	
	//public Book aDd_BoOk(String a, String t, String c) {		
	public Book addBook(String a, String t, String c) {		
		//Book b = new Book(a, t, c, gEt_NeXt_BoOk_Id());
		Book b = new Book(a, t, c, getNextBookId());
		//CaTaLoG.put(b.gEtId(), b);		
		catalog.put(b.getId(), b);		
		return b;
	}

	
	//public Member gEt_MeMbEr(int memberId) {
	public Member getMember(int memberId) {
		//if (MeMbErS.containsKey(memberId)) 
		if (members.containsKey(memberId)) 
			//return MeMbErS.get(memberId);
			return members.get(memberId);
		return null;
	}

	
	//public Book gEt_BoOk(int bookId) {
	public Book getBook (int bookId) {
		//if (CaTaLoG.containsKey(bookId)) 
		if (catalog.containsKey(bookId)) 
			//return CaTaLoG.get(bookId);		
			return catalog.get(bookId);		
		return null;
	}

	
	//public int gEt_LoAn_LiMiT() {
	public int getLoanLimit() {
		//return lOaNlImIt;
		return loanLimit;
	}

	
	//public boolean cAn_MeMbEr_BoRrOw(Member member) {		
	public boolean canMemberBorrow(Member member) {		
		//if (member.gEt_nUmBeR_Of_CuRrEnT_LoAnS() == lOaNlImIt ) 
		if (member.getNumberOfLoans() == loanLimit ) 
			return false;
				
		//if (member.FiNeS_OwEd() >= maxFinesOwed) 
		
		if (member.fineOwed() >= maxFinesOwed) 
			return false;
				
		//for (Loan loan : member.GeT_LoAnS()) 
		for (Loan loan : member.getLoans()) 
			//if (loan.Is_OvEr_DuE()) 
			if (loan.isOverDue()) 
				return false;
			
		return true;
	}

	
	//public int gEt_NuMbEr_Of_LoAnS_ReMaInInG_FoR_MeMbEr(Member MeMbEr) {		
	public int getNumberOfLoansReamainigForMember(Member member) {		
		//return lOaNlImIt - MeMbEr.gEt_nUmBeR_Of_CuRrEnT_LoAnS();
		return loanLimit - member.getNumberOfCurrentLoans();
	}

	
	//public Loan iSsUe_LoAn(Book book, Member member) {
	public Loan issueLoan(Book book, Member member) {
		//Date dueDate = Calendar.gEtInStAnCe().gEt_DuE_DaTe(loanPeriod);
		Date dueDate = Calendar.getInstance().ggetDueDate(loanPeriod);
		//Loan loan = new Loan(gEt_NeXt_LoAn_Id(), book, member, dueDate);
		Loan loan = new Loan(getNextLoanId(), book, member, dueDate);
		//member.TaKe_OuT_LoAn(loan);
		member.takeOutLoan(loan);
		//book.BoRrOw();
		book.borrow();
		//LoAnS.put(loan.GeT_Id(), loan);
		loans.put(loan.getId(), loan);
		currentLoans.put(book.getId(), loan);
		return loan;
	}
	
	
	//public Loan GeT_LoAn_By_BoOkId(int bookId) {
	public Loan getLoanByBookID(int bookId) {
	
		//if (CuRrEnT_LoAnS.containsKey(bookId)) 
		if (currentLoans.containsKey(bookId)) 
			//return CuRrEnT_LoAnS.get(bookId);
			return currentLoans.get(bookId);
		
		return null;
	}

	
	//public double CaLcUlAtE_OvEr_DuE_FiNe(Loan LoAn) {
	public double calculateOverDueFine(Loan loan) {
		//if (LoAn.Is_OvEr_DuE()) {
		if (loan.isoverDue()) {
			//long DaYs_OvEr_DuE = Calendar.gEtInStAnCe().GeT_DaYs_DiFfErEnCe(LoAn.GeT_DuE_DaTe());
			long daysOverDue = Calendar.getInstance().getDaysDiffrence(loan.getDueDate());
			//double fInE = DaYs_OvEr_DuE * FiNe_PeR_DaY;
			double fine = DaysOverDue * finePerDay;
			//return fInE;
			return fine;
		}
		return 0.0;		
	}


	//public void DiScHaRgE_LoAn(Loan cUrReNt_LoAn, boolean iS_dAmAgEd) {
	public void dischargeLoan(Loan currentLoan, boolean isDamaged) {
		//Member mEmBeR = cUrReNt_LoAn.GeT_MeMbEr();
		Member member = currentLoan.getMember();
		//Book bOoK  = cUrReNt_LoAn.GeT_BoOk();
		Book book  = currentLon.getBook();
		
		//double oVeR_DuE_FiNe = CaLcUlAtE_OvEr_DuE_FiNe(cUrReNt_LoAn);
		double overDueFine = calculateOverDueFine(currentLoan);
		//mEmBeR.AdD_FiNe(oVeR_DuE_FiNe);	
		member.addFine(overDueFine);	
		
		mEmBeR.dIsChArGeLoAn(cUrReNt_LoAn);
		bOoK.ReTuRn(iS_dAmAgEd);
		if (iS_dAmAgEd) {
			mEmBeR.AdD_FiNe(damageFee);
			DaMaGeD_BoOkS.put(bOoK.gEtId(), bOoK);
		}
		cUrReNt_LoAn.DiScHaRgE();
		CuRrEnT_LoAnS.remove(bOoK.gEtId());
	}


	public void cHeCk_CuRrEnT_LoAnS() {
		for (Loan lOaN : CuRrEnT_LoAnS.values()) 
			lOaN.cHeCk_OvEr_DuE();
				
	}


	public void RePaIr_BoOk(Book cUrReNt_BoOk) {
		if (DaMaGeD_BoOkS.containsKey(cUrReNt_BoOk.gEtId())) {
			cUrReNt_BoOk.RePaIr();
			DaMaGeD_BoOkS.remove(cUrReNt_BoOk.gEtId());
		}
		else 
			throw new RuntimeException("Library: repairBook: book is not damaged");
		
		
	}
	
	
}
