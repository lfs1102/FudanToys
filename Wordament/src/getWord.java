import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class getWord {
	static String word[] = new String[15000];
	static int loc;
	static String search;
	static boolean out;
	final static int searchLength = 64;
public static void main(String[] args) throws FileNotFoundException {
		Scanner get = new Scanner(new File(".\\wordlist.txt"));
	int n = 0;
	while(get.hasNext()){
		word[n] = get.next();
		n++;
	}n--;

	while(true){
		System.out.println(word[Integer.parseInt(new Scanner(System.in).next())]);
		}
	}
}
