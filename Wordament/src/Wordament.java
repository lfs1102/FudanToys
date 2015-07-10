import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Wordament extends search{
	static String element[][] = new String[4][4];
	static int order[][][] = new int[4][4][2000];
	static StringBuilder string = new StringBuilder(32);
	static boolean chosen[][] = new boolean [4][4];
	static String record[] = new String[2000];
	static int number;
	static int length = -1;
	static int recordFinalOrder[] =new int[2000]; 
	public static void main(String[] args) throws FileNotFoundException {
		importDictionary();
		getCharacter_line();
	//	getCharacter_random();
	//	drawCharacter();
		combine();
		sort();
		finalOutput();
	}
	public static void importDictionary() throws FileNotFoundException{
		Scanner get = new Scanner(new File(".\\wordlist.txt"));
		int n = 0;
		while(get.hasNext()){
			word[n] = get.next();
			n++;
		}n--;
	}
	public static void getCharacter_random(){
		for(int i = 0; i < 4; i ++){
			for(int j = 0; j < 4; j++){
				element[i][j] = String.valueOf((char)((int)(Math.random()*26)+97));
			}
		}
	}
	public static void getCharacter_line(){
		System.out.println("Input 16 chars,use blank to divide:");
		Scanner line = new Scanner(System.in);
		for(int i = 0; i < 4; i ++){
			for(int j = 0; j < 4; j++){
				element[i][j] = line.next();
				
			}
		}
	}
	public static void getCharacter_quick(){
		/*I have scored the first and there is no need to code this method*/
	}
	public static String inPut(){
		return new Scanner(System.in).next();
	}
	public static void drawCharacter(){
		for(int i = 0; i < 4; i ++){
			for(int j = 0; j < 4; j++){
				System.out.print("  "+element[i][j]);
			}
			System.out.print("\n\n");
		}
	}
	public static void printOrder(int a){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(order[i][j][a] == 0)System.out.print("*");
				else System.out.print(order[i][j][a]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public static void copyOrder(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j< 4; j++){
				order[i][j][number+1] = order[i][j][number];
			}
		}
	}
	public static void combine(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				find(i,j);
			}
		}
	}

	public static void sort(){
		int longest = 0;
		int a = 0;
		boolean[] printed = new boolean[2000];
		int b = 0;
		for (int j = 0; j < number; j++) {
			for (int i = 0; i < number; i++) {
				if (!printed[i] && longest <= record[i].length()) {
					longest = record[i].length();
					a = i;
				}
			}
			if(!same(a,b)){recordFinalOrder[b] = a;b++;}
		//	System.out.println(record[a]);
		//	printOrder(a);
			printed[a] = true;
			longest = 0;
		}
	}
	public static boolean same(int a,int b){
		boolean Same = false;
		for(int i = 0; i < b; i++){
			if(record[a].equals(record[recordFinalOrder[i]]))Same = true;
		}
		if(b == 0)return false;
		else if(Same)return true;
		else return false;
	}
	public static void find(int i, int j) {
		if (legal(i, j)) {
			length += element[i][j].length();
			order[i][j][number] = length+1;
			chosen[i][j] = true;
			string.append((element[i][j]));
			guess = string.toString();
			search.binSearch(0, 113808);
			out = false;
			if (length >= 2 && word[loc].equals(guess)){
				record[number] = string.toString(); 
				copyOrder();
				number++;
			}
			if (word[loc].startsWith(guess)) {
				if (legal(i - 1, j + 1))
					find(i - 1, j + 1);
				if (legal(i - 1, j))
					find(i - 1, j);
				if (legal(i - 1, j - 1))
					find(i - 1, j - 1);
				if (legal(i, j - 1))
					find(i, j - 1);
				if (legal(i + 1, j - 1))
					find(i + 1, j - 1);
				if (legal(i + 1, j))
					find(i + 1, j);
				if (legal(i + 1, j + 1))
					find(i + 1, j + 1);
				if (legal(i, j + 1))
					find(i, j + 1);
			}
		}
		for(int dt = length;dt >length-element[i][j].length();dt--){
			string.deleteCharAt(dt);
		}
		length -= element[i][j].length();
		order[i][j][number] = 0;
		chosen[i][j] = false;
	}
	public static boolean legal(int i,int j){
		if(i >= 0 && i<= 3 && j >= 0 && j <= 3 && (!chosen[i][j]))return true;
		else return false;
	}	
	public static void finalOutput(){
	a:	for(int i = 0; i < (int)(number/7); i++){
			for(int j = 0; j <7; j++){
				System.out.print(record[recordFinalOrder[i*7+j]]+tabs(1));
				if(record[recordFinalOrder[i*7+j]].length() < 8)System.out.print(tabs(1));
				if(record[recordFinalOrder[i*7+j]].equals(record[recordFinalOrder[i*7+j+1]]))break a;
			}
			System.out.println();
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 7; k++){
					for (int l = 0; l < 4; l++) {
						if(order[j][l][recordFinalOrder[i * 7 + k]] == 0)System.out.print("* ");
						else System.out.print(order[j][l][recordFinalOrder[i * 7 + k]]+" ");
					}
					System.out.print(tabs(1));
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static String tabs(int n){
		String s = "";
		for(int i = 0; i < n; i++){
			s+="\t";
		}
		return s;
	}
}