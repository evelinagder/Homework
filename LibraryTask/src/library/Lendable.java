package library;

import java.util.TreeMap;

public  abstract class Lendable extends Reading {
	
	protected static final double INTEREST = 1;//%
	private String author;
	TreeMap <String, String> takeHistory;
	protected int lendingTime;
	protected double lendingTax;

	public Lendable(String tytle, int issueDate, String publisher, String type, String author) {
		super(tytle, issueDate, publisher, type);
		this.author = author;
		takeHistory=new TreeMap<String,String>();
	}

	void increaseLendingTax(){
		this.lendingTax = this.lendingTax*(1 + INTEREST/100);
	}
	public double getTax(){
		return this.lendingTax;
	}
	
	 abstract void resetLendingTax();
	 abstract void returnMe(Library library);
}
