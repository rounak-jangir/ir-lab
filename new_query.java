import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class new_query extends rocchio {
	public static List<String> new_query_formation(long[] query_optimal){
		RankList Words = new RankList();
		Map <String,List<Integer>> Terms = new HashMap<>();
		String doc_folder = Words.getFolder();
		File directory = new File(doc_folder);
		File[] fList = directory.listFiles();
		int N = fList.length;
		Terms = Words.list(doc_folder);
		List<String> query_terms = new ArrayList();
		int i =0;
		for(Map.Entry<String, List<Integer>> entry : Terms.entrySet()){
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
            if(query_optimal[i] != 0){
            	query_terms.add(key);
            }
            i++;
		}
		System.out.println("After Pseudo_Feedback\n");
		return query_terms;
		
		
		
	}

}
