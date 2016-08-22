package library;

public class BookChecker extends Thread {
	
	private Lendable read;
	BookChecker(Lendable read){
		this.read=read;
	}
	
	@Override 
	public void run(){
		try {
			Thread.sleep(read.lendingTime);
			while(true){
				if(interrupted()){
					return;
				}
				read.increaseLendingTax();
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			return;
		}
		
	}

}
