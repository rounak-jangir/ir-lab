import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class user extends new_query{
	public static void main(String[] args){
		InvertedIndexer abcd = new InvertedIndexer();
		System.out.println("Please Enter Your Query");
		String query;
		Scanner sc= new Scanner(System.in);
		query = sc.nextLine();
		System.out.println(getwordzz(query));
		getDocuments(getwordzz(query));
		int N = abcd.getSize();
		System.out.print("N ::"+N);
		System.out.println("\nEnter the Document Id's of the document which are relevant according to you.\n");
		long[] pos_feedback = new long[4];
		double[] top_docs = new double[10];
		top_docs =  getDocuments(getwordzz(query));
		
		for(int i=0;i<4;i++){
			pos_feedback[i] = (long)top_docs[i+1];
		}
		long[] sum_re = new long[N];
		long[] sum_irre = new long[N];
		long[] r = new long[N];
		long[] ir = new long[N];
		long[] q_v = new long[N];
		
		for(int i=0;i<4;i++){
			//System.out.println(" i == "+i);
			r  = RelevantVector(pos_feedback[i],query);
			for(int j=0;j<N;j++){
				sum_re[j] = sum_re[j] + r[j];
				//System.out.print("sum_re[j] : " + sum_re[j]);
			}
			QueryVector(query);
			}
		/*System.out.println(" Sum of Irrelevant Documents Vector\n");
		for(int b=0;b<N;b++){
	
				System.out.print(sum_irre[b]);
		}*/
		System.out.println("\n");
		//System.out.println(" Sum of Relevant Documents Vector\n");
		/*for(int b=0;b<N;b++){
	
				System.out.print(sum_re[b]);
		}*/
		System.out.println("\n");		
		//System.out.println(" Final Query Vector\n");
		
	q_v = QueryVector(query);
	/*for(int b=0;b<N;b++){
				System.out.print(q_v[b]);
	}*/
		
		//System.out.println("\n");		
		long[] query_optimal = new long[N];
		
		for(int j=0;j<N;j++){
			query_optimal[j] = q_v[j]+sum_re[j];
		}
		/*for(int j=0;j<N;j++){
			System.out.print(query_optimal[j]);
		}*/
		for(int j=0;j<N;j++){
			if(query_optimal[j] < 0){
				query_optimal[j] = 0;
			}
			
			}
		/*System.out.println("\n Final Optimal Query\n");
		for(int j=0;j<N;j++){
			System.out.print(query_optimal[j]);
		}*/
		getDocuments(new_query_formation(query_optimal));
		
		}
	}
