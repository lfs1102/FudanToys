import java.io.*;
import java.util.*;
public class changword {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter(".\\wordlist.txt");
		Scanner get = new Scanner(new File(".\\14282words.txt"));
		String[] word = new String[14282];
		int c = 0;
	a:	while(get.hasNext()){
			word[c] = get.nextLine();
			c++;
		}
		Arrays.sort(word);
		for(int i = 0; i < c; i++){
			
			
			fw.write(word[i] + "\r\n");
		}
		
/*	a:	while(get.hasNext()){
			word = get.nextLine();
			for(int i = 0; i < word.length(); i++){
				if(word.charAt(i) == ' ')continue a;
			}
			for(int i = 0; i < word.length(); i++){
				fw.write(String.valueOf(word.charAt(i)).toLowerCase());
			}
			fw.write("\r\n");
		}
		/*
		
	/*	while(get.hasNext()){
			word = get.nextLine();
			if(word.length() < 3||word.length() > 18)continue;
			fw.write(word+"\r\n");
		}
		*/
		
		
		/*	a:	while(get.hasNext()){
			word = get.nextLine();
			for(int i = 0; i < word.length(); i++){
				if(word.charAt(i) == '['){fw.write("\r\n");continue a;}
				fw.write(String.valueOf(word.charAt(i)));
			}
		//	fw.write("\r\n");
		}*/
		fw.close();
		get.close();
	}
}