package task1;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Test {

		
		public static void main(String[] args) {
			
			
				File f= new File("12469_war_and_peace.txt");
				File[] files =divideFile(f,2);
		}
			
				private static File[] divideFile(File file, int count){
					File[] files=null;
					try (Scanner sc = new Scanner(file)){
						int rowCount=0;
						while(sc.hasNextLine()){
						rowCount++;	
						sc.nextLine();
						}
					System.out.println(rowCount);//sum count of all rows
					int fileLength=rowCount/count;//how many rows should be in one file;
					
						files= new File[count];// a file for every thread
	
						System.out.println(files.length);
						for (int i = 0; i < files.length; i++) {
							files[i]=new File("file"+i+".txt");
						}
						for (int i = 0; i < files.length; i++) {
							java.io.PrintStream ps= new java.io.PrintStream(files[i]);
							try (Scanner sc1 = new Scanner(file)){
							while(sc1.hasNextLine()){//READS ALL TEXT
								String row= sc1.nextLine();//TAKES EVERY ROW
								for( int j = 1; j<fileLength;j++){
									ps.append(row);
								}
									sc1.nextLine();
							
							
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
