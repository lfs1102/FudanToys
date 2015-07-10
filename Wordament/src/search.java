import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class search {
		static String word[] = new String[120000];
		static String guess;
		static int loc;
		static int times;
		static boolean out;
		static boolean exist;
		final static int searchLength = 16;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner get = new Scanner(new File(".\\wordlist.txt"));
		int n = 0;
		while(get.hasNext()){
			word[n] = get.next();
			n++;
		}n--;
		System.out.print(n+"\n");
		while(true){
			get = new Scanner(System.in);
			guess = get.next();
			times = 0;
			binSearch(0,n);
			out = false;
			System.out.println(exist+"  "+loc+"  "+word[loc]+"  search "+times+" times");
		}
	}
	
	public static void binSearch(int start,int end){
		loc = (int)((start+end)/2);
		exist = true;
		times++;
		int compare = guess.compareTo(word[loc].substring(0,Math.min(guess.length(), word[loc].length())));
		if(!out){
			if(compare <= 0){
				if(loc - start > searchLength){
					binSearch(start,loc);
				}
				else {
					orderSearch(start,loc);
					out = true;
				}
			}
			else{
				if(end - loc > searchLength){
					binSearch(loc,end);
				}
				else{
					orderSearch(loc,end);
					out = true;
				}
			}
		}
		
	}
	
	public static void orderSearch(int start,int end){
		int compare = 0;
		int endIndex = 0;
		for(int i = start; i <= end; i++){
			compare = guess.compareTo(word[i].substring(0,Math.min(guess.length(), word[i].length())));
			if(compare == 0){
				loc = i;
				break;
			}
		}
		if(compare != 0)exist = false;
	}

}