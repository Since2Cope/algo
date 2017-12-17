
public class Main {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.push("zzz1",5);
        queue.push("zzz2",1);
        queue.push("zzz3",8);
        queue.push("zzz4",1);
        queue.push("zzz5",5);
        queue.output();
        queue.deleteMin();
        System.out.println("without min");
        queue.output();
        System.out.println("without max");
        queue.deleteMax();
        queue.output();
    }
}
