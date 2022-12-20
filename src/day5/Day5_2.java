package day5;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Day5_2 {
	
	public static void main(String[] args) {
		
		//Create scanner, file
		File f = new File("src/day5/inputDay5.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Create a stack of lines
		//maximum height of crate stack is 8
		//every letter is in the 4th character
		Stack<String> horizontalLines = new Stack<String>();
		scan.useDelimiter("\\n");
		for(int i = 0; i < 8; i++) 
			horizontalLines.push(scan.next());
		
		//create an ArrayList of stacks
		ArrayList<Stack<String>> crateStacks = new ArrayList<Stack<String>>();
		for(int i = 0; i < 9; i++) {
			crateStacks.add(new Stack<String>());
		}
		
		//populate each crate stack
		while(horizontalLines.size() != 0) {
			String line = horizontalLines.pop();
			//a crate is present every 4 characters
			for(int i = 1; i < line.length(); i += 4) {
				//if there is a valid crate, push it to its respective stack
				if(line.charAt(i) != ' ') {
					crateStacks.get(i/4).push(String.valueOf(line.charAt(i)));
				}
			}
		}
		
		//skip to commands
		scan.next();
		scan.next();
		
		//read and execute commands
		while(scan.hasNext()) {
			//read command, create scanner to separate
			String command = scan.next();
			Scanner commandReader = new Scanner(command);
			commandReader.useDelimiter(" ");
			
			//commands will always be of format:
			//move x from y to z
			int x = -1;
			int y = -1;
			int z = -1;
			
			while(commandReader.hasNext()) {
				//set x, y, z
				String term = commandReader.next();
				try {
					if(x == -1) 
						x = Integer.parseInt(term);
					else
					if(y == -1) 
						y = Integer.parseInt(term)-1;
					else
						z = Integer.parseInt(term)-1;
				}
				catch(Exception e) {
					//Empty to continue in case of exception
				}
			}
			
			//execute the command
			//Should be restacked in same order as it was originally
			ArrayList<String> beingMoved = new ArrayList<String>();
			for(int i = 0; i < x; i++) {
				beingMoved.add(crateStacks.get(y).pop());
			}
			for(int i = beingMoved.size()-1; i >= 0; i--) {
				crateStacks.get(z).push(beingMoved.get(i));
			}
			
			//close the scanner when finished
			if(!commandReader.hasNext()) 
				commandReader.close();
			
		}
		
		//print the crate stacks
		for(Stack<String> s : crateStacks) {
			System.out.println(s);
		}
		
		//close scanner when finished
		scan.close();
		
	}
	
}
