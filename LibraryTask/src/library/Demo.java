package library;

import library.Library.Criteria;

public class Demo {

	public static void main(String[] args) {
		
	
		Reader penka= new Reader("Pena Marinova",10);
		penka.start();
		try {
			penka.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reader.library.showCatalouge(Criteria.BOOK);
		Reader.library.showCatalouge(Criteria.MAGAZINE);
		Reader.library.showCatalouge(Criteria.TEXTBOOK);
		

	}

}
