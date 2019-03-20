import java.util.LinkedList;

public class MyGraph {
    private int vertexCount; //кол-во вершин
    private int edgeCount; //кол-во ребер
    private LinkedList<Integer>[] adjLists; //массив связаных списков

    public MyGraph(int vertexCount){
        if (vertexCount < 0){
            throw new IllegalArgumentException("the number of vertices cannot be negative");
        }
        this.vertexCount = vertexCount;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    public int vertexCount(){
        return vertexCount;
    }

    public int edgeCount(){
        return edgeCount;
    }

    public void addEdge(int v1, int v2){
        if (v1 < 0 || v2 < 0){
            throw new IllegalArgumentException("the number of vertices cannot be negative");
        }
        if (v1 >= vertexCount || v2 >= vertexCount){
            throw new IndexOutOfBoundsException("no vertex with that number");
        }
        adjLists[v1].add(v2);
        adjLists[v2].add(v1);
    }

    public LinkedList<Integer> adjList(int vertex){
        return adjLists[vertex];
    }
}
