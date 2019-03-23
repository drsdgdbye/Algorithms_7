import java.util.LinkedList;

public class WidthFirstPath {
    private static int INF = Integer.MAX_VALUE;
    private LinkedList<Integer> queue;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] pathTo;
    private int source;

    public WidthFirstPath(MyGraph graph, int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= graph.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        this.queue = new LinkedList<>();
        this.source = source;
        this.marked = new boolean[graph.vertexCount()];
        this.edgeTo = new int[graph.vertexCount()];
        this.pathTo = new int[graph.vertexCount()];
        for (int i = 0; i < pathTo.length; i++) {
            pathTo[i] = INF;
        }
        wfs(graph, source);
    }

    private void wfs(MyGraph graph, int v) {
        queue.addLast(v);
        marked[v] = true;
        pathTo[v] = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : graph.adjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.addLast(w);
                    edgeTo[w] = vertex;
                    pathTo[w] = pathTo[vertex] + 1;
                }
            }
        }
    }

    public boolean hasPathTo(int dist) {
        if (dist < 0) {
            throw new IllegalArgumentException();
        }
        if (dist >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return marked[dist];
    }

    public LinkedList pathTo(int dist) {
        if (!hasPathTo(dist)) {
            return null;
        } else {
            LinkedList<Integer> stack = new LinkedList<>();
            int vertex = dist;
            while (vertex != source) {
                stack.push(vertex);
                vertex = edgeTo[vertex];
            }
            return stack;
        }
    }

    public int distTo(int dist) {
        if (dist < 0) {
            throw new IllegalArgumentException();
        }
        if (dist >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return pathTo[dist];
    }
}
