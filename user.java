import java.util.Scanner;


public class user extends RankList{
	public static void main(String[] args){
		System.out.println("Please Enter Your Query");
		String query;
		Scanner sc= new Scanner(System.in);
		query = sc.nextLine();
		System.out.println(getwordzz(query));
		getDocuments(getwordzz(query));
	}
}
