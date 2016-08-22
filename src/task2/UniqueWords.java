package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UniqueWords {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file= new File("12469_war_and_peace.txt");
		System.out.println(sortWords(file));

	}

	public static SortedSet<Map.Entry<String,Integer>> sortWords(final File f){
		Map <String,Integer>map= new HashMap<String, Integer>();
		
		try (Scanner sc = new Scanner(f)){
		while(sc.hasNext()){
				int wordCount=0;
				String word= sc.next();
				word= word.toLowerCase();
				if(map.containsKey(word)){
					wordCount= map.get(word);
					wordCount++;
					map.put(word,wordCount);
					sc.next();
				}
				else{
					map.put(word,1);
					sc.next();
				}
				
			}
		}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

//		Map<Integer,String> myNewHashMap = new HashMap<>();
//		for(Map.Entry<String,Integer> entry : map.entrySet()){
//		    myNewHashMap.put(entry.getValue(), entry.getKey());
		return(entriesSortedByValues(map));
	
		}
	

	
			static SortedSet<Map.Entry<String,Integer>> entriesSortedByValues(Map<String,Integer> map) {
			SortedSet<Map.Entry<String,Integer>> sortedEntries = new TreeSet<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String,Integer>>() {
            @Override public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2) {
  
                if(e1.getValue()>e2.getValue()){
                	return  -1;
                }
               if(e1.getValue()<e2.getValue()){
            	   return 1;
               }
               return 0;
            }
        }
    );
    sortedEntries.addAll(map.entrySet());
    return sortedEntries;
}
}
