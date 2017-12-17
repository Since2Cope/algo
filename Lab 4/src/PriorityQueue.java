import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PriorityQueue<T> {
    private List<Element<T>> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public T findMin() {
        return queue.get(queue.size()-1).getValue();
    }

    public T findMax() {
        return queue.get(0).getValue();
    }

    public void push(T value, int priority) {
        queue.add(new Element<T>(value,priority));
        reorganize();
    }

    public void deleteMin() {
        queue.remove(queue.size()-1);
        reorganize();
    }

    public void deleteMax() {
        queue.remove(0);
        reorganize();
    }

    public void output(){
        queue.stream().forEach(x-> System.out.println(x.getValue()+"\t\tpriority: "+x.getPriority()));
    }

    private void reorganize() {
        queue = queue.stream().sorted(((o1, o2) -> o2.getPriority().compareTo(o1.getPriority()))).
                collect(Collectors.toList());
    }


    class Element<T> {
        private T value;

        private Integer priority;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public Element(T value, Integer priority) {
            this.value = value;
            this.priority = priority;
        }
    }
}
