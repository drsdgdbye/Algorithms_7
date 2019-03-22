public class Main {
    public static void main(String[] args) {
        MyGraph g = new MyGraph(10);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 8);
        g.addEdge(7, 8);
        g.addEdge(7, 9);


        WidthFirstPath wfp = new WidthFirstPath(g, 0);
        System.out.println(wfp.hasPathTo(9));
        System.out.println(wfp.pathTo(9));
        System.out.println(wfp.distTo(9));
    }
}
