package library;

import java.util.Random;

public class Reader extends Thread{

	private Lendable takenBook;
	private double money;
	private int readingTime;
	static Library library= new Library();
	
	Reader(String name, int readingTime){
		setName(name);
		this.readingTime=readingTime;
		this.money=200;
	}
	public void takeRead(Lendable b){
		this.takenBook=b;
	}
	public void returnReading(Library biblioteka,String lendDate, String returnDate) {
		if(this.takenBook == null){
			return;
		}
		biblioteka.recieveRead(takenBook,this,lendDate,returnDate);
		this.takenBook=null;
		
	}
	public void setMoney(double money){
		this.money=money;
	}
	public double getMoney(){
		return this.money;
	}
	@Override
	public void run(){
		int rand = (new Random().nextInt(Library.Criteria.values().length));
		library.lendReading(this, "Date1",Library.Criteria.values()[rand]);//TODO dates
		try {
			Thread.sleep(readingTime*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnReading(library,"Date1","Date2");//TODO dates
	}
	
	
	
}
