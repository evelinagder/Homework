package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WarOrPease {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file= new File("12469_war_and_peace.txt");
		System.out.println(warOrPeace(file));
		
	}
	public static String warOrPeace(final File f){
		
	int war=0;
	int peace=0;
		try (Scanner sc = new Scanner(f)){
			while(sc.hasNext()){
					int wordCount=0;
					String word= sc.next();
					word= word.toLowerCase();
					if(word.equals("war")){
						war++;
					}
					if(word.equals("peace")){
						peace++;
					}
			}
		}
					catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
	return "War: "+war+" Peace: "+peace;
	}
}
