import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class rocchio extends RankList{
	public static long[] RelevantVector(long rel_docid,String query){
		RankList Words = new RankList();
		Map <String,List<Integer>> Terms = new HashMap<>();
		String doc_folder = Words.getFolder();
		File directory = new File(doc_folder);
		File[] fList = directory.listFiles();
		int N = fList.length;
		Terms = Words.list(doc_folder);
		//System.out.println("Term size :: "+ Terms.size());
		List<Long> rel = new ArrayList() ;
		long[] rel_vector = new long[Terms.size()];
		for(int k=0;k<Terms.size();k++){
			rel_vector[k]=0;
		}
		int j=0;
		int m = 0;
		List<String> query_terms = Words.getwordzz(query);
		//long[][] frq = new long[query_terms.size()][N];
		int count = 0;
		for(Map.Entry<String, List<Integer>> entry : Terms.entrySet()){
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
			if(values.contains(rel_docid)){
				for(int i=0;i<values.size();i++){
					if (values.get(i) == rel_docid){
						count++;
					}
				}
				rel_vector[m] = count;
				count = 0;
				m++;
			}
			else{
				rel_vector[m]= count;
				m++;
			}
			}
				
			
				//for(j=1;j<fList.length;j++){
		/*		for (int i=1;i<values.size();i++){
					if(j == (long)values.get(i)){
        				count++;
					}
				}
				rel_vector[m] = count;
				m++;
				}
			//}
		}*/
					/*if(key.equalsIgnoreCase(query_terms.get(i))){
						frq = Words.Matrix(query_terms);
						rel_vector[j] = frq[i][(int)rel_docid];
						j++;	
						}
					}
					}
					}*/
	/*	for(int a = 0;a<query_terms.size();a++){
			System.out.println("\n");
			for(int b=0;b<N;b++){
		
					System.out.println(frq);
			}
		}*/
		/*System.out.println("Relevant Documents Vector\n");
		for(int b=0;b<Terms.size();b++){
	
				System.out.print(rel_vector[b]);
		}*/
		//System.out.println("\n"+rel_vector.length+"\n");	
			return rel_vector;	
			}
	public static long[] IrrelevantVector(long irrel_docid,String query){
		RankList Words = new RankList();
		Map <String,List<Integer>> Terms = new HashMap<>();
		String doc_folder = Words.getFolder();
		File directory = new File(doc_folder);
		File[] fList = directory.listFiles();
		int N = fList.length;
		Terms = Words.list(doc_folder);
		//System.out.println("Term size :: "+ Terms.size());
		List<Long> irrel = new ArrayList() ;
		long[] irrel_vector = new long[Terms.size()];
		for(int k=0;k<Terms.size();k++){
			irrel_vector[k]=0;
		}
		int j=0;
		int m = 0;
		List<String> query_terms = Words.getwordzz(query);
		//long[][] frq = new long[query_terms.size()][N];
		int count = 0;
		for(Map.Entry<String, List<Integer>> entry : Terms.entrySet()){
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
			if(values.contains(irrel_docid)){
				for(int i=0;i<values.size();i++){
					if (values.get(i) == irrel_docid){
						count++;
					}
				}
				irrel_vector[m] = count;
				count = 0;
				m++;
			}
			else{
				irrel_vector[m]= count;
				m++;
			}
			}
				
			
				//for(j=1;j<fList.length;j++){
		/*		for (int i=1;i<values.size();i++){
					if(j == (long)values.get(i)){
        				count++;
					}
				}
				rel_vector[m] = count;
				m++;
				}
			//}
		}*/
					/*if(key.equalsIgnoreCase(query_terms.get(i))){
						frq = Words.Matrix(query_terms);
						rel_vector[j] = frq[i][(int)rel_docid];
						j++;	
						}
					}
					}
					}*/
	/*	for(int a = 0;a<query_terms.size();a++){
			System.out.println("\n");
			for(int b=0;b<N;b++){
		
					System.out.println(frq);
			}
		}*/
		/*System.out.println("Irrelevant Documents Vector\n");
		for(int b=0;b<Terms.size();b++){
	
				System.out.print(irrel_vector[b]);
		}*/
		//System.out.println("\n"+irrel_vector.length+"\n");	
			return irrel_vector;	
			}

	public static long[] QueryVector(String query){
		RankList Words = new RankList();
		Map <String,List<Integer>> Terms = new HashMap<>();
		String doc_folder = Words.getFolder();
		File directory = new File(doc_folder);
		File[] fList = directory.listFiles();
		int N = fList.length;
		Terms = Words.list(doc_folder);
		List<Long> rel = new ArrayList() ;
		long[] query_vector = new long[Terms.size()];
		for(int k=0;k<Terms.size();k++){
			query_vector[k]=0;
		}
		int j=0;
		List<String> query_terms = Words.getwordzz(query);
		//long[][] frq = new long[query_terms.size()][N];
		
		for(Map.Entry<String, List<Integer>> entry : Terms.entrySet()){
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
				for (int i=0;i<query_terms.size();i++){
					if(key.equalsIgnoreCase(query_terms.get(i))){
						query_vector[j] = 1;
							
						}
					
					}
				j++;
					}
					
					
			//System.out.println("Query Vector \n");
			/*for(int b=0;b<Terms.size();b++){
		
					System.out.print(query_vector[b]);
			}
			System.out.println("\n"+ query_vector.length+"\n");
			*/return query_vector;
		}
				
				
			}

	
	
		
			
		
		/*for(String key:Terms.keySet()){
		System.out.println(key);
		}*/
		
		
	
		



