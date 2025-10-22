/*
Creates a graph of connections between letters then determines the shortest distance from one specific letter to another. Completed April 16, 2025 by Atharva Srivastava and Veda Rabishanker.
*/

import java.util.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.*;

public class Graph{

	private static HashMap<String, ArrayList<String>> graph;

	/*
	Creates the adjacency list
	*/

	public Graph(){
		 graph = new HashMap<String, ArrayList<String>>();
	}

	/*
	post: adds a letter to the adjacency list
	Pre: needs the adjacency list to be initialized
	*/

	public static void addVertex(String character){
		graph.put(character, new ArrayList<String>());
	}

	/*
	pre: needs to the adjacency list to be initialized
	Creates a connection between 2 letters if they aren’t already connected and adds them to the graph if needed before connecting
	Post: establishes a connection between 2 letters
	*/

	public static void addEdge(String character1, String character2){
		if(!graph.containsKey(character1) && !graph.containsKey(character2)){
			addVertex(character1);
			addVertex(character2);
		}else if(!graph.containsKey(character1)){
			addVertex(character1);
		}else if(!graph.containsKey(character2)){
			addVertex(character2);
		}

		if(!graph.get(character1).contains(character2)){
			graph.get(character1).add(character2);
			graph.get(character2).add(character1);
		}	
	}

	/*
	Checks to see if there’s a connection between 2 letters and how many steps it takes to get from 1 to the other
	Pre: requires only 2 letters to be inputted has to be same case as adjacency list
	Post: returns 0 if they’re the same letter and -1 if there’s no connection, else returns the distance
	*/

	public static int returnPathLength(String toSplit){
		String start = toSplit.substring(0, 1);
		String end = toSplit.substring(1); 

		if(start.equals(end)){
			return 0;
		}

		HashMap<String, Integer> distanceFromStart = new HashMap<String, Integer>();

		for(String x : graph.keySet()){
			distanceFromStart.put(x, -1);
		}

		distanceFromStart.put(start, 0);

	
		Queue<String> toCheck = new LinkedList<>();
		toCheck.add(start);
		Queue<String> checked = new LinkedList<>();
		checked.add(start);
  
		while(toCheck.size() != 0){
			int depth = (int) distanceFromStart.get(toCheck.peek());
			checked.offer(toCheck.peek());
			for(String x : graph.get(toCheck.poll())){
				if(distanceFromStart.get(x) == -1){
					distanceFromStart.put(x, depth+1);
				}
				if(!checked.contains(x)){
					toCheck.offer(x);
				}
			}
			if(distanceFromStart.get(end) != -1){
				return (int) distanceFromStart.get(end);
			}
		}
		return -1;
	}

	public static HashMap<String, ArrayList<String>> returnGraph(){
		return graph;
	}

	public String toString(){
		return graph.toString();
	}

}