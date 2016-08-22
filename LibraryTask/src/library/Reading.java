package library;


import java.util.*;

public abstract class Reading {
	private String tytle;
	protected int issueDate;
	private String publisher;
	private String type;
	
	public Reading(String tytle,int issueDate, String publisher, String type) {
		if(tytle !=null  && publisher != null){
		this.tytle = tytle;
		this.issueDate = issueDate;
		this.publisher = publisher;
		this.type=type;
		
		}
	}
	public String getType(){
		return this.type;
	}
	public String getTytle(){
		return this.tytle;
	}
	

}
