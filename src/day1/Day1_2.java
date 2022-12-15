package day1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1_2 {
	
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
		
		//separate each elf into a stack of numbers
		Stack<Integer> elfCalories = new Stack<Integer>();
		ArrayList<Integer> sums = new ArrayList<Integer>();
		
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
			
			//add that sum to the ArrayList of sums
			sums.add(sum);
			
		}
		
		//initialize array for top 3 ranks
		int[] ranks = {0, 0, 0};
		
		//for each rank
		for(int i = 0; i < ranks.length; i++) {
			//go through the arrayList of sums
			int maxIndex = 0;
			for(int b = 0; b < sums.size(); b++) {
				//find the max sum currently in the ArrayList
				if(sums.get(b) > ranks[i]) {
					ranks[i] = sums.get(b);
					maxIndex = b;
				}
			}
			//remove all instances of the max sum from the arrayList
			sums.remove(maxIndex);
		}
		
		//Display the sum of the top 3
		System.out.println((ranks[0] + ranks[1] + ranks[2]));
		
	
	}
	
	
}
