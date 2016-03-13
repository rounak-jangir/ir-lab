import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class User extends InvertedIndexer{
	public static void main (String[] args){
        InvertedIndexer indexer = new InvertedIndexer();
        final String directory ;
        //="/home/rounak/Desktop/Desktop1/hindi/";
        System.out.println("Enter the location of the folder to be indexed\n");
        Scanner sc = new Scanner(System.in);
        directory = sc.nextLine();
        Map<String,List<Integer>> work = new HashMap<>(); 
        work = indexer.list(directory);
        System.out.println("Enter a term to find its TF and IDF\n");
        String query = sc.nextLine();
        float t = (work.get(query).size());
        System.out.println(t);
        float r = indexer.getSize()/t;
        System.out.println(r);
        double idf = Math.log(r);
        Map<String,List<Integer>> work_TF = new HashMap<>();
        work_TF = indexer.getDocumentsTF();
        List <Integer> arr1 = new ArrayList<>();
        List <Integer> arr2 = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry : work.entrySet()){
            String key = entry.getKey();
            if (key.equalsIgnoreCase(query)){
            	arr1 = entry.getValue();
            }
        }
        System.out.println(arr1);
        for(Map.Entry<String, List<Integer>> entry : work_TF.entrySet()){
            String key = entry.getKey();
            if (key.equalsIgnoreCase(query)){
            	arr2 = entry.getValue();
            }
        }
        System.out.println(arr2);
        List <Integer> TF = new ArrayList<>();
        System.out.println("TF of the term :: ");
		for(int j=0;j<indexer.getSize();j++){
			TF.add(j, 0);
		}
		for (int i=0;i<t;i++){
			int l = arr1.get(i);
			int m = arr2.get(i);
        	TF.set(l-1, m);
        }
        
        System.out.println(TF);
        System.out.println("IDF of the term :: ");
        System.out.println(TF.size());
        System.out.println(idf);
    }
}

