package library;

import java.util.*;

public class Library {
	
	
	ArrayList<Book> books=new ArrayList<Book>();
	ArrayList<TextBook> textBooks=new ArrayList<TextBook>();
	ArrayList<Magazine> magazines=new ArrayList<Magazine>();
	
	HashMap<Lendable,Thread> lendedBooks;

	enum Criteria {
		MAGAZINE, BOOK, TEXTBOOK
	};

	public Library() {
		lendedBooks= new HashMap<Lendable,Thread>();
		
		Book voina=new Book("voina", 1967, "Rodina", "Historical", "Ivan Ivanov");
		Book lavina=new Book("Lavina", 1950, "Rodina", "Novel", "Blaga DImitrova");
		TextBook geografia= new TextBook("Geografia",1978,"Alina","Geografical","Penko Mladenov");
		TextBook history=new TextBook("HIstory of Serbia",1999,"Beograd","Historical","Slobodan Petrovic");
		TextBook historyB=new TextBook("History of Bulgaria",1989,"Sofia","Historical","Marin Hristov");
		Magazine gracia= new Magazine("Grazia",2016,"MKB","fashion",34);
		Magazine eva= new Magazine("EVA",2016,"IVN GROUP","fashion",12);
		Magazine natGeo= new Magazine("NAtional Geografic",2006, "NATG","Sience",12);
		Magazine natGeo2= new Magazine("NAtional Geografic",2006, "NATG","Sience",10);
		addBook(voina);
		addBook(lavina);
		addTextBook(geografia);
		addTextBook(history);
		addTextBook(historyB);
		addMagazine(gracia);
		addMagazine(eva);
		addMagazine(natGeo);
		addMagazine(natGeo2);
		
	}

	public void addBook(Book book) {
		if (book != null) {
			books.add(book);
		}
	}

	public void addTextBook(TextBook textBook) {
		if (textBook != null) {
			textBooks.add(textBook);
		}
	}

	public void addMagazine(Magazine magazine) {
		if (magazine != null) {
			magazines.add(magazine);
		}
	}

	public void showCatalouge(Criteria criteria) {
		switch (criteria) {
		case BOOK:
			Collections.sort(books, new Comparator<Book>() {

				@Override
				public int compare(Book o1, Book o2) {
					if (o1.getType() == o2.getType()) {
						return o1.issueDate-o2.issueDate;
						// razuchi kak shte stanat s dati? kak se pravi zadna
						// data, kato v excel??
					}
					return o1.getType().compareTo(o2.getType());
				}
			});
			System.out.println(books);
			break;
		case MAGAZINE:
			Collections.sort(magazines, new Comparator<Magazine>() {

				@Override
				public int compare(Magazine o1, Magazine o2) {
					if (o1.getType() == o2.getType()) {
						if(o1.getTytle().equals(o2.getTytle())){
							return o1.getIssueNumber()-o2.getIssueNumber();
						}
						return o1.getTytle().compareTo(o2.getTytle());
					}
					return o1.getType().compareTo(o2.getType());
				}
			});
			System.out.println(magazines);
			break;
		case TEXTBOOK:
			Collections.sort(textBooks, new Comparator<TextBook>() {

				@Override
				public int compare(TextBook o1, TextBook o2) {
					if (o1.getType() == o2.getType()) {
						return o1.getTytle().compareTo(o2.getTytle());
					}
					return o1.getType().compareTo(o2.getType());
				}
			});
			System.out.println(textBooks);
			break;
		}

	}
		 public void lendReading(Reader reader, String lendDate, Criteria criteria){
			 //TODO bookChecker, IncreaseTax...sleep..add book to lendedReadings...case Magazine, Case TextBook
			switch(criteria){
			case BOOK:
				Book taken= books.get(new Random().nextInt(books.size()));
				taken.takeHistory.put(lendDate,""); //with dates?
				Lendable one=taken;
				reader.takeRead(one);
				System.out.println(reader.getName() + " takes " + taken.getTytle());
				books.remove(taken);
				Thread checker= new BookChecker(taken);
				lendedBooks.put(taken, checker);
				
				break;
			case TEXTBOOK:
				TextBook taken1=textBooks.get(new Random().nextInt(textBooks.size()));
				taken1.takeHistory.put(lendDate,"");//DATES
				Lendable two=taken1;
				reader.takeRead(two);
				System.out.println(reader.getName() + " takes " + taken1.getTytle());
				textBooks.remove(taken1);
				Thread checker1= new BookChecker(taken1);
				lendedBooks.put(taken1, checker1);
				break;
			case MAGAZINE:
				System.out.println("Lending magazines is not permited!");
				break;
				
			}
		 }

		public void recieveRead(Lendable takenBook,Reader reader,String lendDate,String today) {
			//pay!
			System.out.println("The reader must pay "+takenBook.getTax());
		reader.setMoney(reader.getMoney()-takenBook.getTax());
		System.out.println("The reader has "+reader.getMoney()+" left.");
		//add record for lend
		takenBook.takeHistory.put(lendDate,today);// with dates? ovverides the previous record(lenddReading)
		//resert TAX
		takenBook.resetLendingTax();
		//interupt i remove from Lended Books register
		lendedBooks.get(takenBook).interrupt();
		lendedBooks.remove(takenBook);
		//return to library
		takenBook.returnMe(this);
		
			
			
		}

}
