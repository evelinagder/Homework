package library;

public class TextBook extends Lendable {
	
	static final double TAX = 3;
	
	public TextBook(String tytle, int issueDate, String publisher, String type, String author) {
		super(tytle, issueDate, publisher, type, author);
		this.lendingTime=1500;
		this.lendingTax=TAX;
	}
	public String toString() {
		
		return this.getType()+": "+this.getTytle()+" "+this.issueDate;
  }
	void resetLendingTax(){
		this.lendingTax = TAX;
	}
	@Override
	void returnMe(Library library) {
		library.addTextBook(this);
		
	}
	

}
