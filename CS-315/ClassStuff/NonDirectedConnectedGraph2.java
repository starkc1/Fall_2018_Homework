import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;

/**
 *
 * @author dgb
 * @date 11/27/2018 This has a breadth-first traversal.
 */
public class NonDirectedConnectedGraph2<T> {
    private ArrayList<T> vertices;
    private ArrayList<ArrayList<T>> adjacencyLists;

    public NonDirectedConnectedGraph2() {
        vertices = new ArrayList();
        adjacencyLists = new ArrayList();
    }

    public void addVertex(T vertex) {
        if (vertex == null)
            return;
        if (vertices.contains(vertex))
            return;
        vertices.add(vertex);
        adjacencyLists.add(new ArrayList());
    }

    public void addEdge(T vertex, T adjacent) {
        if (vertex == null || adjacent == null)
            return;
        if (vertex.equals(adjacent))
            return;
        if (!vertices.contains(vertex))
            return;
        if (!vertices.contains(adjacent))
            return;
        int posOfVertex = getVertexLocation(vertex);
        adjacencyLists.get(posOfVertex).add(adjacent);
    }

    public int getVertexLocation(T vertex) {
        if (vertex == null)
            return -1;
        return vertices.indexOf(vertex);
    }

    public T getVertex(int pos) {
        if (pos < 0 || pos >= vertices.size())
            return null;
        return vertices.get(pos);
    }

    public ArrayList<T> getVertexList() {
        return vertices;
    }

    public ArrayList<T> getVertexAdjacencyList(T vertex) {
        if (vertex == null)
            return null;
        if (!vertices.contains(vertex))
            return null;
        int posOfVertex = getVertexLocation(vertex);
        return adjacencyLists.get(posOfVertex);
    }

    public String[] breadthFirst(T start) {
        if (start == null)
            return null;
        ArrayList<T> queue = new ArrayList();
        ArrayList<T> visitedList = new ArrayList();
        queue.add(start);
        visitedList.add(start);
        while (!queue.isEmpty()) {
            T current = queue.remove(0);
            ArrayList<T> adjList = getVertexAdjacencyList(current);
            for (T vertex : adjList) {
                if (!visitedList.contains(vertex)) {
                    System.out.println(current.toString() + "->" + vertex.toString());
                    queue.add(vertex);
                    visitedList.add(vertex);
                }
            }
        }

        return queue;
    }

    public void depthFirst(T start) {
        if (start == null)
            return;
        ArrayList<T> visitedList = new ArrayList();
        System.out.println(start.toString());
        visitedList.add(start);
        depthFirst(start, visitedList);
    }

    public void depthFirst(T start, ArrayList<T> visitedList) {
        ArrayList<T> adjList = getVertexAdjacencyList(start);
        if (adjList.isEmpty())
            return;
        for (T vertex : adjList) {
            if (!visitedList.contains(vertex)) {
                System.out.println(vertex.toString());
                visitedList.add(vertex);
                depthFirst(vertex, visitedList);
            }
        }
    }

    public static void main(String[] args)
    {
        NonDirectedConnectedGraph2<String> graph 
                = new NonDirectedConnectedGraph2();
      
        

        try {
            File file = new File("/Users/stark/StarkDev/Fall_2018_Homework/CS-315/ClassStuff/graphInput.txt");
            Scanner scanner = new Scanner(file);

            String vertexs[] = scanner.nextLine().split(" ");
            for (int i = 0; i < vertexs.length; i++) {
                graph.addVertex(vertexs[i]);
            }

            while (scanner.hasNextLine()) {
                String line[] = scanner.nextLine().split(" ");

                for (int i = 0; i < line.length; i++) {
                    graph.addEdge(line[0], line[i]);
                }
            }
            scanner.close();
            Scanner newScanner = new Scanner(System.in);
            System.out.println("What Vertex to start from?");
            String vertex = newScanner.nextLine();  
            newScanner.close();
            String vertexArray[] = graph.breadthFirst(vertex);

            System.out.println(vetexArray.toString());
            
        } catch (Exception e) {

        }

        

        

        //You must add vertices before adding edges
        // graph.addVertex("A");
        // graph.addVertex("B");
        // graph.addVertex("C");
        // graph.addVertex("D");
        // graph.addVertex("E");
        
        // graph.addEdge("A", "B");
        // graph.addEdge("A", "C");
        // graph.addEdge("A", "E");
        
        // graph.addEdge("B", "A");
        // graph.addEdge("B", "C");
        // graph.addEdge("B", "D");
        // graph.addEdge("B", "E");
        
        // graph.addEdge("C", "A");
        // graph.addEdge("C", "B");
        
        // graph.addEdge("D", "B");
        
        // graph.addEdge("E", "A");
        // graph.addEdge("E", "B");
        
        // dump(graph);
        
        // graph.breadthFirst("A");  
        // System.out.println("*************");
        // graph.depthFirst("D");
    }// end main

    public static void dump(NonDirectedConnectedGraph2<String> graph) {
        ArrayList<String> vertices = graph.getVertexList();

        for (String vertex : vertices) {
            System.out.print(vertex + " is connected to ");
            ArrayList<String> adjacencyList = graph.getVertexAdjacencyList(vertex);
            System.out.print("[");
            for (int i = 0; i < adjacencyList.size(); i++) {
                System.out.print(adjacencyList.get(i));
                if (i < adjacencyList.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }

}// end class
