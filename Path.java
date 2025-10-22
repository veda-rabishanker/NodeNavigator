/*
Calls upon graph to use a text file of specific letters a specific number of times and find the distance from 1 letter to 
another in a graph. Completed April 16, 2025 by Atharva Srivastava and Veda Rabishanker.
*/
import java.util.*;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Path{

	public static int cases;
	public static Scanner fileReader; 
	public static Graph graph;

	/*
	Goes through all the lines in graphs.dat to figure out the path between 2 specific letters
	*/

	public static void main(String args[]){
        try{
            fileReader = new Scanner(new FileReader("graphs.dat"));
            cases = Integer.parseInt(fileReader.nextLine());
        }
        catch(FileNotFoundException e){
            System.out.println("cannot find file");
            return;
        }

        System.out.println("Nodes   : Shortest Path");
        System.out.println("-----------------------");
        for(int i = 0; i < cases; i++){
        	placement();
        }	
    }

    /*
	Creates an adjacency list for a line of letters by calling upon methods from the Graph class and then finds the distance between 2 letters and returns the result
	Pre: needs access to methods from the Graph class, the graph variable, and graphs.dat
	Post: returns “No Path” or the distance between 1 letter and another
	*/

	public static void placement(){
		graph = new Graph();

		String line = fileReader.nextLine();

		String[] sep = line.split(" ");

		for(String store : sep){
			if(!store.isEmpty() && store != null){
				graph.addEdge(store.substring(0,1), store.substring(1));
			}
		}

		String toFind = fileReader.nextLine();
		System.out.print(toFind.substring(0,1) + " to " + toFind.substring(1) + ": ");
		int pathLength = graph.returnPathLength(toFind);
		if(pathLength != -1){
			System.out.println(pathLength);
		}
		else{
			System.out.println("No Path");
		}
		

	}
}