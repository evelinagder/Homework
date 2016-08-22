package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountCommasWithTreads {

	public static void main(String[] args) {
	System.out.println("Time for counting with one thread: "+countCommas(1));
//	System.out.println("Time with 4 Threads "+countCommas(4));
//	System.out.println("Time with 7 threads "+countCommas(7));
//	System.out.println("Time with 12 threads "+countCommas(12));
	}
	
	public static long countCommas(int threadCount){
		//returns time needed for all threads to read the book.
		//how to start the tread -executor 
		File f= new File("12469_war_and_peace.txt");
		File[] files =divideFile(f,threadCount);
		ExecutorService executor=Executors.newFixedThreadPool(threadCount);
		long start= System.currentTimeMillis();
		for(int i =0; i<files.length;i++){
			executor.execute( new CountCommas(files[i]));
		}
		executor.shutdown();
		
		while(!executor.isTerminated()){
			
		}
		long end = (System.currentTimeMillis()-start);
		return end;
	}
	//divide file? PROBLEM!!!!!
	private static File[] divideFile(File file, int count){
		File[] files=null;
		try (Scanner sc = new Scanner(file)){
			int wordCount=0;
			while(sc.hasNext()){
			wordCount++;	
			sc.next();
			}
			System.out.println(wordCount);//sum count of all words
			int fileLength=wordCount/count;//how many words should be in one file;
			
				files= new File[count];// a file for every thread
				System.out.println(files.length);
				for (int i = 0; i < files.length; i++) {
					files[i]=new File("file"+i+".txt");
				}
				for (int i = 0; i < files.length; i++) {
					java.io.PrintStream ps= new java.io.PrintStream(files[i]);
					try (Scanner sc1 = new Scanner(file)){
					while(sc1.hasNext()){//READS ALL TEXT
						String word= sc1.next();//TAKES EVERY WORD
						for( int j = 1; j<fileLength;j++){
							ps.append(word);
							sc1.next();
						}
		
					  }
					}
					ps.close();
				
				}
			}
		
			 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		System.out.println(files.length);
		return files;
	}


	
	
}
