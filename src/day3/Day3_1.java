//Angelo Tolentino
//@a-tol
//12/15/2022
//Advent of Code submissions
//Day 3 Puzzle 1

package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//the set of capital letters is typecast char-to-int 65 (a) thru 90 (z)
		//the set of lowercase letters is typecast char-to-int 97 thru 122
		
		//create file (of input), scanner (for input) instance variables
		File f = new File("src/day3/inputDay3.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//each sack separated by return
		scan.useDelimiter("[\\n\\r]");
		
		//create sack stack to hold each sack's string representation
		Stack<String> sacks = new Stack<String>();
		
		//get all stacks from input file
		while(scan.hasNext()) {
			sacks.push(scan.next());
		}
		
		//create sum instance variable
		int prioritySum = 0;
		
		//for every sack in the sack stack
		while(sacks.size() != 0) {
			//currently tracked sack
			String sack = sacks.pop();
			//representations of left and right halves of stack
			String leftHalf = sack.substring(0, (sack.length()/2));
			String rightHalf = sack.substring((sack.length()/2), sack.length());
			System.out.println(sack);
			
			//parse through each item in left half to find match in right half
			for(int i = 0; i < leftHalf.length(); i++) {
				boolean toBreak = false; //break applicable if there is 1 and only 1 matching item
				for(int b = 0; b < rightHalf.length(); b++) {
					//lowercase letter is the similar element
					//character-cast-to-integer minus 96 is the position in the alphabet for lowercase
					//priority is the position in the alphabet
					if(leftHalf.charAt(i) == rightHalf.charAt(b) && (int) leftHalf.charAt(i) > 90) {
						prioritySum += (int) leftHalf.charAt(i)-96; //add priority
						toBreak = true; //break outer loop
						break; //break inner loop
					}
					//capital letter is similar element
					//character-cast-to-integer minus 64 is the position in the alphabet for capital
					//priority is the position in the alphabet + 26 for capital letters
					if(leftHalf.charAt(i) == rightHalf.charAt(b) && (int) leftHalf.charAt(i) <= 90) {
						prioritySum += (int) leftHalf.charAt(i)-64+26; //add priority
						toBreak = true; //break outer loop
						break; //break inner loop
					}
				}
				if(toBreak) break;
			}
		}
		
		//print sum
		System.out.println(prioritySum);
		scan.close();
		

	}

}
