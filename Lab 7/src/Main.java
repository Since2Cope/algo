public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(16);
        tree.add(4);
        tree.add(2);
        tree.add(1);
        tree.info();
        tree.outputWidht();
        System.out.println(tree.delete(1, true));
        tree.info();
        tree.outputWidht();

    }
}
