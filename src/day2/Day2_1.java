//Angelo Tolentino
//@a-tol
//12/15/2022
//Advent of Code submissions
//Day 2 Puzzle 1

package day2;

import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//rock paper scissors but ONLY following the strategy guide
		
		//A, X is rock
		//B, Y is paper
		//C, Z is scissors
		//left is opponent
		//right is "you"
		
		
		//generate instance variables
		//matches contains each suggested throw and response
		//file references the input text (strategy guide)
		//scanner scans the input text
		
		File f = new File("src/day2/inputDay2.txt");
		Stack<String> matches = new Stack<String>();
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//scan list of matches
		scan.useDelimiter("[\\n\\r]");
		while(scan.hasNext()) {
			matches.push(scan.next());
		}
		
		//determine score
		int score = 0;
		
		//go through all match outcomes
		while(matches.size() != 0) {
			String match = matches.pop();
			scan = new Scanner(match);
			scan.useDelimiter(" ");
			//turns a match into an opponent character
			//and a player character
			//match string --> player string --> player charArray --> player char
			char opponent = scan.next().toCharArray()[0];
			char you = scan.next().toCharArray()[0];
			
			//determine wins, losses, scores
			//score calculation:
			//	left column is choice score
			//	right column is result score
			switch(opponent) {
			case 'A':	//opponent picks rock
				if(you == 'X') { score += (1 + 3); break; } //player picks rock and ties
				if(you == 'Y') { score += (2 + 6); break; } //player picks paper and wins
				if(you == 'Z') { score += (3 + 0); break; } //player picks scissors and loses
			case 'B':	//opponent picks paper
				if(you == 'X') { score += (1 + 0); break; } //player picks rock and loses
				if(you == 'Y') { score += (2 + 3); break; } //player picks paper and ties
				if(you == 'Z') { score += (3 + 6); break; } //player picks scissors and wins
				break;
			case 'C':	//opponent picks scissors
				if(you == 'X') { score += (1 + 6); break; } //player picks rocks and wins
				if(you == 'Y') { score += (2 + 0); break; } //player picks paper and loses
				if(you == 'Z') { score += (3 + 3); break; } //player picks scissors and ties
				break;
			}
			
		}
		
		System.out.println(score);
		scan.close();
		
	}

}
