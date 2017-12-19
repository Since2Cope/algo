public class Main {
    public static void main(String[] args) {
        Integer matrix[][] = {
                {0, 1, 20, null, null, null, null, null},
                {-1, 0, 9, -1, 2, null, null, null},
                {-20, -9, 0, -3, null, null, -1, null},
                {null, 1, 3, 0, -3, -4, 1, null},
                {null, -2, null, 3, 0, -4, null, null},
                {null, null, null, 4, 4, 0, null, null},
                {null, null, 1, - 1, null, null, 0, 8},
                {null, null, null, null, null, null, -8, 0}};
        Graph myGraph = new Graph(matrix);
        System.out.println(myGraph);
        myGraph.removeNode(5);
        System.out.println(myGraph);
        myGraph.searchPaths(0);
    }
}
