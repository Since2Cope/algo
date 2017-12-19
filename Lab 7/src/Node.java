
public class Node {
    private Node parent;
    private Node lSon;
    private Node rSon;
    private int value;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setlSon(Node lSon) {
        this.lSon = lSon;
    }

    public void setrSon(Node rSon) {
        this.rSon = rSon;
    }

    public Node getlSon() {
        return lSon;
    }

    public Node getrSon() {
        return rSon;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }
}