package library;

public class Book extends Lendable{
	
	static final double TAX = 2;
	public Book(String tytle, int issueDate, String publisher, String type, String author) {
		super(tytle, issueDate, publisher, type, author);
		this.lendingTime=3000;
		this.lendingTax=TAX;
		
	}

	@Override
	public String toString() {
		
		return this.getType()+": "+this.getTytle()+"; Issue date:  "+this.issueDate;
	}
	void resetLendingTax(){
		this.lendingTax = TAX;
	}

	@Override
	void returnMe(Library library) {
		library.addBook(this);
		
	}
	
	


}
