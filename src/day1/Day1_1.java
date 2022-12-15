//Angelo Tolentino
//@a-tol
//12/15/2022
//Advent of Code submissions
//Day 1 Puzzle 1

package day1;

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1_1 {
	
	public static void main(String[] args) {
		
		//every section of numbers separated by a line break is a group
		//a group has multiple numbers, separated by a line break
		File f = new File("src/day1/inputDay1.txt");
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//group each section of calories
		Stack<String> elves = new Stack<String>();
		//separate groups of elves
		scan.useDelimiter("\\n\\r");
		
		while(scan.hasNext()) {
			String x = scan.next();
				elves.push(x);
//			}
		}
		
		int max = 0;
		
		//separate each elf into a stack of numbers
		Stack<Integer> elfCalories = new Stack<Integer>();
		
		//while there are still elves
		while(elves.size() != 0 ) {
			
			//get each calorie value
			String elf = elves.pop();
			scan = new Scanner(elf);
			scan.useDelimiter("[\\n\\r]");
			
			
			while(scan.hasNext()) {
				String x = scan.next();
				if(x.length() != 0) //avoids empty strings
					elfCalories.push(Integer.parseInt(x));
			}
			
			//get the sum of all calories
			int sum = 0;
			while(elfCalories.size() != 0) {
				sum += elfCalories.pop();
			}
			if(sum > max) max = sum;
			
		}
		
		System.out.println(max);
		scan.close();
	
	}
	
	
}
