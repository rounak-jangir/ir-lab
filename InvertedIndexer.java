import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InvertedIndexer extends HindiStemmer {
	
    private int n;
    private ArrayList<String> docs;
    private HashMap<String,List<Integer>> words_TF;
    
	public Map<String,List<Integer>> list(String directoryName){
		
        File directory = new File(directoryName);
        File[] fList = directory.listFiles(); 
        HashMap<String,List<Integer>> words = new HashMap<>();
        words_TF = new HashMap<>();
        System.out.println("Total number of documents are "+fList.length);
        System.out.println("\n");
        //System.out.println("Mapper\n");
        //System.out.println("File Name \t\t DocumentID\n");	
        int j=0;
        docs = new ArrayList<String>(fList.length+1);
        n = fList.length;
        for (File file : fList){
            if (file.isFile()){
            	
            	docs.add(j, file.getName());
            	j++;
            	ArrayList<String> liststop = new ArrayList<String>();
            	System.out.println(file.getName() +"\t" +j);
                try {
					FileReader fr1 = new FileReader(new File("stopwords_hi.txt"));
					Scanner sc1 = new Scanner(fr1);
					while (sc1.hasNext()){
						String stop = sc1.next();
						liststop.add(stop);
					}
					Scanner in = new Scanner(new FileReader(file));	
					while (in.hasNext()){
						String z = in.next();
						String s = stem(z);
						if(words.containsKey(s)){
							List <Integer>list1 = new ArrayList();
							List <Integer>list2 = new ArrayList();
							List <Integer>list4 = new ArrayList();
							list2 = words.get(s);
							list4 = words_TF.get(s);
							/*for (int i=list4.size();i<=j;i++){
								list4.add(i, 0);
							}*/
							if(list2.contains(j)){
								list1 = list2;
								int l = list4.size();
								int m = list4.get(l-1);
								list4.set(l-1,m+1);
							}
							else{
								list1 = list2;	
								list1.add((Integer)j);
								list4.add(1);
							}		
							words.put(s,list1);
							words_TF.put(s, list4);
						}
						else if(!(liststop.contains(s))){
							List <Integer>list3 = new ArrayList();
							List <Integer>list5 = new ArrayList();
							list3.add((Integer)j);
							list5.add(1);
							words.put(s,list3);
							words_TF.put(s,list5);
						}
					}
				}
				catch (Exception e) {
					System.out.println(e.getClass());
				}	
			}
            
        }
        System.out.println("\n");
        //System.out.println("Term List Size :: "+words.size());
        
        //System.out.println("Term   PostingList");
        for(Map.Entry m:words_TF.entrySet()){
			System.out.println(m.getKey()+" \t "+m.getValue());  
		}        
        //System.out.println("\n\n");
        //for(Map.Entry m:docs_matrix.entrySet()){
			//System.out.println(m.getKey()+" \t "+m.getValue());  
		//}        
        
	
		return words;
	
	}
	
	public int getSize(){
		return this.n;
	}

	public ArrayList<String> getDocumentsList() {
        return this.docs;
	}
	
	public Map<String,List<Integer>> getDocumentsTF() {
        return this.words_TF;
	}
}