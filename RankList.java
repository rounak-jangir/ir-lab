import java.text.BreakIterator;
import java.util.Formatter;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.*;

public class RankList extends InvertedIndexer{
	private static String directoryName ;
	private static long[][] tfidf;
	private static int N;
	public static List<String> getwordzz(String text) {
	    List<String> wordzz = new ArrayList<String>();
	    BreakIterator breakIterator = BreakIterator.getWordInstance();
	    breakIterator.setText(text);
	    int lastIndex = breakIterator.first();
	    while (BreakIterator.DONE != lastIndex) {
	        int firstIndex = lastIndex;
	        lastIndex = breakIterator.next();
	        if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
	            wordzz.add(text.substring(firstIndex, lastIndex));
	        }
	    }
	    return wordzz;
	}
	
	public static double[] getDocuments(List<String> wordzz){
		InvertedIndexer indexer = new InvertedIndexer();
        final String directory ;
        //="/home/rounak/Desktop/Desktop1/hindi/";
        System.out.println("Enter the location of the folder to be indexed\n");
        Scanner sc = new Scanner(System.in);
        directory = sc.nextLine();
        Map<String,List<Integer>> work = new HashMap<>(); 
        work = indexer.list(directory);
        double tfidf[][] = new double[wordzz.size()][indexer.getSize()];

        for (int i =0;i<wordzz.size();i++){
        float t = ((work.get(wordzz.get(i))).size());
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
            if (key.equalsIgnoreCase(wordzz.get(i))){
            	arr1 = entry.getValue();
            }
        }
        System.out.println(arr1);
        for(Map.Entry<String, List<Integer>> entry : work_TF.entrySet()){
            String key = entry.getKey();
            if (key.equalsIgnoreCase(wordzz.get(i))){
            	arr2 = entry.getValue();
            }
        }
        System.out.println(arr2);
        List <Integer> TF = new ArrayList<>();
        System.out.println("TF of the term :: ");
		for(int j=0;j<indexer.getSize();j++){
			TF.add(j, 0);
		}
		for (int k=0;k<t;k++){
        	TF.set((arr1.get(k))-1, arr2.get(k));
        }

		
	        	for(int p=0;p<indexer.getSize();p++){
		        	tfidf[i][p] = TF.get(p)*idf;
	        	}
		    }
        double[] sum = new double[indexer.getSize()];
    	
		for(int o=0;o<indexer.getSize();o++){
			sum[o] = 0;
		}
			
		for(int y=0;y<indexer.getSize();y++){
			for(int k=0;k<wordzz.size();k++){
				sum[y] = sum[y] + tfidf[k][y];
			}
		}
		/*
		for(int s=0;s<fList.length;s++){
			System.out.print(sum[s]);
		}*/
		System.out.print("\n");
		double[] sum1 = new double[indexer.getSize()];
		for(int h=0;h<indexer.getSize();h++){
			sum1[h] = h;
		}
		for (int g = 0; g < indexer.getSize(); g++) {
		      for (int v = 1; v < indexer.getSize()-g; v++) {
		        if (sum[v-1] < sum[v]) /* For descending order use < */
		        {
		          double swap       = sum[v-1];
		          sum[v-1]   = sum[v];
		          sum[v] = swap;
		          double swap1       = sum1[v-1];
		          sum1[v-1]   = sum1[v];
		          sum1[v] = swap1;
		       
		        }
		      }
		    }
        ArrayList<String> documents = new ArrayList<String>();
        documents = indexer.getDocumentsList();
		 			System.out.println("\nTop 10 documents according to your search\n");
		 			System.out.println("Rank\tScore\tDocID\tTitle");
		for(int s=0;s<10;s++){
			Formatter fmt = new Formatter();
			fmt.format("%.4f",sum[s]);
			System.out.println(s+1+"\t"+fmt+"\t"+sum1[s]+ "\t"+ indexer.getDocumentsList().get((int)sum1[s]-1));
		}
		

		return sum1;
		
	}
	public long[][] Matrix(List<String> wordzz){
		
		return this.tfidf;
	}
	public String getFolder() {
		return this.directoryName;
        
}
	
}
		

