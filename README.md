# NodeNavigator: Breadth-First Search Shortest Path Finder
**Date Completed:** April 16, 2025  
**Course:** CS3  

---

## Project Overview
This program constructs undirected graphs from input data and uses **Breadth-First Search (BFS)** to determine the shortest path between two nodes.  
Each node is represented by a single character, and edges are defined as character pairs in the input file.  

The program reads from a `.dat` file, builds the adjacency list representation of the graph, and prints the length of the shortest path (or “No Path” if none exists).

---

## Features
- Implements **BFS traversal** to ensure shortest path discovery  
- Supports **multiple test cases** through one input file  
- Dynamically builds **adjacency lists** for each graph  
- Clean console output displaying node pairs and their shortest path lengths

---

## How It Works
1. **graphs.dat** begins with an integer indicating the number of test cases.  
2. Each test case includes:
   - **Line 1:** Character pairs representing undirected edges (e.g., `CA XY RS`).  
   - **Line 2:** A single character pair (e.g., `CD`) representing the nodes to test.  
3. For each test case:
   - The graph is constructed using the `Graph` class.  
   - BFS is performed to determine the shortest path length between the two nodes.  
   - The result is printed in the console.  

---

## Input (`graphs.dat`)
9<br>
CA XY RS YS ST TB AB BD RJ<br>
CD<br>
PQ QX AX BH CH DX EX FX GH AB BC CD DE AE CE FD TH<br>
PT<br>
AE EI IO OU BC CD DF FG<br>
AG<br>
HI HJ HK KQ KM KN MO MP MQ<br>
HQ<br>
AB CD EF GH CB ED GF HI<br>
AI<br>
TV XY AZ XT JK KL LT JX MN TN JL NO OP PT NX<br>
VZ<br>
AB BC CD DE EF FG GH HI IJ AE AC JZ FZ AZ<br>
AZ<br>
NO PQ RS TU OU RP AB CD EF GH AH CE NS FA GQ<br>
DT<br>
IX VX CX DX MX LX BY<br>
IB<br>

## Output
Nodes   : Shortest Path <br>
—---------------------- <br>
C and D : 3<br>
P and T : 6<br>
A and G : No Path<br>
H and Q : 2<br>
A and I : 8<br>
V and Z : No Path<br>
A and Z : 1<br>
D and T : 14<br>
I and B : No Path<br>


---

## Classes Overview

### **Graph.java**
Handles:
- Creating and storing the adjacency list  
- Adding vertices and edges  
- Performing BFS to determine shortest paths  

### **Path.java**
Handles:
- Reading input from `graphs.dat`  
- Calling `Graph` methods to build the graph and find paths  
- Displaying formatted output  

---

## How to Run
1. Clone Git Repo
```bash
git clone https://github.com/veda-rabishanker/NodeNavigator.git
```
2. Compile the Java files:  
```bash
javac Path.java 
```
3. Run the file:
```bash
java Path
