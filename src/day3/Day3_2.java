//Angelo Tolentino
//@a-tol
//12/15/2022
//Advent of Code submissions
//Day 3 Puzzle 2

package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day3_2 {

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
		
		//create a stack that will hold each group of 3 sacks
		Stack<Stack<String>> groups = new Stack<Stack<String>>();
		//create a stack that will hold 3 sacks, each a string
		Stack<String> sacks = new Stack<String>();
		
		//get all stacks from input file
		while(scan.hasNext()) {
			sacks.push(scan.next());
			//when the stack has 3 sacks
			if(sacks.size() == 3) {
				groups.push(sacks);
				//avoiding same memory address stuff
				sacks = new Stack<String>();
			}
		}
		
		//create sum instance variable
		int prioritySum = 0;
		
		//for every group of sacks
		//not very cool O(n^4) time complexity acknowledged
		while(groups.size() != 0) {
			//for each group
			sacks = groups.pop();
			String sack1 = sacks.pop();
			String sack2 = sacks.pop();
			String sack3 = sacks.pop();
			//check if a letter is common between all three
			//by parsing through sack 1, sack 2, and sack 3 one letter at a time
			for(int i = 0; i < sack1.length(); i++) {
				//given that there will be only 1 shared letter
				boolean toBreak = false;
				for(int b = 0; b < sack2.length(); b++) {
					for(int k = 0; k < sack3.length(); k++) {
						//implicit transitive charAt(b) == charAt(k)
						//if there is a capital letter match
						if(sack1.charAt(i) == sack2.charAt(b) && sack1.charAt(i) == sack3.charAt(k) && sack1.charAt(i) <= 90) {
							prioritySum += (int) sack1.charAt(i)-64+26; //add priority
							toBreak = true;
							break;
						}
						//if there is a lowercase letter match
						if(sack1.charAt(i) == sack2.charAt(b) && sack1.charAt(i) == sack3.charAt(k) && sack1.charAt(i) > 90) {
							prioritySum += (int) sack1.charAt(i)-96; //add priority
							toBreak = true;
							break;
						}
					}
					if(toBreak) break;
				}
				if (toBreak) break;
			}
		}
		
		System.out.println(prioritySum);
		scan.close();
		

	}

}
