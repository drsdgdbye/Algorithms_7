import java.util.LinkedList;

public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;
    private LinkedList<Integer> dfsStack;

    public DepthFirstPath(MyGraph g, int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= g.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        this.source = source;
        this.edgeTo = new int[g.vertexCount()];
        this.marked = new boolean[g.vertexCount()];
        this.dfsStack = new LinkedList<>();
        dfs(g, source);
    }

    private void dfs(MyGraph graph, int v) {
        dfsStack.push(v);
        marked[v] = true;
        while (!dfsStack.isEmpty()) {
            int vertex = dfsStack.pop();
            for (int w : graph.adjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    dfsStack.push(w);
                    edgeTo[w] = vertex;
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
}
