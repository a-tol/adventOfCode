package day4;

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Day4_1 {

	//For each pair of ranges, count the number of pairs
	//in which one range is fully contained in the other.
	
	//Assume the following:
	//There are two ranges w-x, y-z
	//One range is full within the other if and only if:
	// w >= y && x <= z
	//	OR
	// w <= y && x >= z
	
	//15, 30 and 16, 29
	//	15 <= 16 and 30 >= 29
	
	//4, 5 and 3, 6
	// 4 >= 3 and 5 <= 6
	
	
	public static void main(String[] args) {
		
		//Generate file, scanner, stack of pairs
		File f = new File("src/day4/inputDay4.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stack<String> pairs = new Stack<String>();
		
		//read each pairing and add to a stack
		scan.useDelimiter("[\\n\\r]");
		
		while(scan.hasNext()) {
			pairs.push(scan.next());
		}
		
		//counter for intercontained pairs
		int count = 0;
		
		while(pairs.size() != 0) {
			//ascertain individual ranges
			String pair = pairs.pop();
			String[] ranges = pair.split(",");
			
			//ascertain boundaries of each range
			//(array of bounds will always be size 2)
			String[] range1 = ranges[0].split("-");
			String[] range2 = ranges[1].split("-");
			
			//store boundaries from strings to integers
			int w = Integer.parseInt(range1[0]);
			int x = Integer.parseInt(range1[1]);
			int y = Integer.parseInt(range2[0]);
			int z = Integer.parseInt(range2[1]);
			
			//following the methodology of above, decide
			if((w >= y && x <= z) || (w <= y && x >= z))
				count++;
		}
		
		System.out.println(count);
		scan.close();
		
	}

}
