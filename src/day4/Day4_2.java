package day4;

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class Day4_2 {

	//For each pair of ranges, count the number of pairs
	//in which one range overlaps with the other.
	
	//Assume the following:
	//There are two ranges w-x, y-z
	//One range overlaps with the other if and only if:
	//	Case where w-x is before y-z
	//		x >= y && w < z
	//	OR
	//	Case where y-z is before w-x
	// 		z >= w && y < x
	//	OR
	//	Case where y-z is fully contained in w-x
	//		w >= y && x <= z
	//	OR
	//	Case where w-z is fully contained in w-x
	// 		w <= y && x >= z
	
	
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
		scan.useDelimiter("\n");
		
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
			if((w >= y && x <= z) || (w <= y && x >= z) || (x >= y && w < z) || (z >= w && y < x))
				count++;
		}
		
		System.out.println(count);
		scan.close();
		
	}

}
