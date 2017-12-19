import java.util.Arrays;

public abstract class TraversalTreeWidth {

    private int[] values;
    private int number = 0;

    public void addToValues(int x) {
        values[number++] = x;
    }

    public TraversalTreeWidth() {
        values = new int[20];
    }

    public int[] getValues() {
        return Arrays.copyOf(values, number);
    }

    private void traversalDepth(Node node, int depth) {
        if (node == null)
            return;
        if (node.getlSon() != null) {
            node = node.getlSon();
            if (depth == 0)
                doAction(node, false);
            else
                traversalDepth(node, depth - 1);
            node = node.getParent();
        }
        if (node.getrSon() != null) {
            node = node.getrSon();
            if (depth == 0)
                doAction(node, false);
            else
                traversalDepth(node, depth - 1);
        }
        return;
    }

    public int[] travesal(Node node, int depth) {
        if (node != null)
            doAction(node, false);
        else
            return values;
        for (int i = 0; i < depth; i++) {
            doAction(null, true);
            traversalDepth(node, i);
        }
        return values;
    }

    abstract void doAction(Node node, boolean isLevel);
    //isLevel using for special action in case transition to next level
}

