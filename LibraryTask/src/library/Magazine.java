package library;

public class Magazine extends Reading {
	
	private int issueNumber;
	public Magazine(String tytle, int issueDate, String publisher, String type, int issueNumber) {
		super(tytle, issueDate, publisher, type);
		this.issueNumber = issueNumber;
	}
	
	@Override
	public String toString() {
		
		return this.getType()+": "+this.getTytle()+" - "+this.issueNumber;
	}


    	public int getIssueNumber(){
    		return this.issueNumber;
    	}
}