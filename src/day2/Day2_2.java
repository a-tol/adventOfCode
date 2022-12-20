//Angelo Tolentino
//@a-tol
//12/15/2022
//Advent of Code submissions
//Day 2 Puzzle 2

package day2;

import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//rock paper scissors but ONLY following the strategy guide mk. 2
		
		//A is rock
		//B is paper
		//C is scissors
		
		//X is you need to lose
		//Y is you need to draw
		//Z is you need to win
		
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
		
		//for each match
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
			//	left column is result score
			//	right column is choice score
			switch(opponent) {
			case 'A':	//opponent picks rock
				if(you == 'X') { score += (0 + 3); break; } //player loses and picks scissors
				if(you == 'Y') { score += (3 + 1); break; } //player ties and picks rock
				if(you == 'Z') { score += (6 + 2); break; } //player wins and picks paper
			case 'B':	//opponent picks paper
				if(you == 'X') { score += (0 + 1); break; } //player loses and picks rock
				if(you == 'Y') { score += (3 + 2); break; } //player ties and picks paper
				if(you == 'Z') { score += (6 + 3); break; } //player wins and picks scissors
				break;
			case 'C':	//opponent picks scissors
				if(you == 'X') { score += (0 + 2); break; } //player loses and picks paper
				if(you == 'Y') { score += (3 + 3); break; } //player ties and picks scissors
				if(you == 'Z') { score += (6 + 1); break; } //player wins and picks rock
				break;
			}
			
		}
		
		System.out.println(score);
		scan.close();
		
	}

}
