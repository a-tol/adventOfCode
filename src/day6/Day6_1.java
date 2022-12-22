//Angelo Tolentino
//@a-tol
//12/22/2022
//Advent of Code submissions
//Day 6 Puzzle 1

package day6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6_1 {
	
	//the datastream is a sequence of characters
	//the start of message flag is a 4 letter string
	//without any duplicate letters
	//objective:
	//display the amount of characters processed until
	//the start of message flag is found

	public static void main(String[] args) {
		
		//input reader
		File f = new File("src/day6/inputDay6.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get the datastream
		//boolean that tracks if the substring contains a duplicate letter
		String input = scan.next();
		boolean containsSimilar = true;
		
		//bounds of 4-letter substring
		int left = 0;
		int right = 4;
		
		//will return -1 if there is no start of datastream
		int charMarker = -1;
		
		//reading the entire datastream
		while(right <= input.length()) {
			//if there is no duplicate letter in the substring
			//it is the start of message marker
			if(!containsSimilar(input.substring(left, right))) {
				charMarker = right;
				break;
			}
			//continue reading the datastream
			left++;
			right++;
		}
		
		//print the last one
		System.out.println(charMarker);

	}
	
	static boolean containsSimilar(String seq) {
		//for loop that reads a substring and
		//checks for a duplicate letter
		for(int i = 0; i < seq.length(); i++) {
			for(int b = i+1; b < seq.length(); b++) {
				//if there is a duplicate letter
				//return true
				if(seq.charAt(i) == seq.charAt(b)) {
					return true;
				}
			}
		}
		//if there is none return false
		return false;
	}

}
