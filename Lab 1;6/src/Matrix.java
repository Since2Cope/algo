import java.util.HashMap;
import java.util.Map;

public class Matrix {
    private Integer rows = 5;
    private Integer columns = 5;
    private Map<String, Double> matrix;

    public Matrix() {
        matrix = new HashMap<>();
        for (Integer i = 0; i < rows; i++) {
            for (Integer j = 0; j < columns; j++) {
                if (i%2==0)
                    matrix.put(i.toString() + " " + j.toString(), Math.random() * 10);
                else
                    matrix.put(i.toString() + " " + j.toString(), 0d);
            }
        }
    }

    public void setLElement(Integer row, Integer column, Double value) {
        matrix.put(row.toString() + " " + column.toString(), value);
    }

    public Double getElement(Integer row, Integer column) {
        return matrix.get(row.toString() + " " + column.toString());
    }

    public void output() {
        for (Integer i = 0; i < rows; i++) {
            for (Integer j = 0; j < columns; j++) {
                System.out.print(matrix.get(i.toString() + " " + j.toString()) + "\t");
            }
            System.out.println();
        }
    }

    public void plus(Double value) {
        matrix.forEach((s, aDouble) -> matrix.put(s, aDouble + value));
    }

    public void minus(Double value) {
        matrix.forEach((s, aDouble) -> matrix.put(s, aDouble - value));
    }

    public void multiply(Double value) {
        matrix.forEach((s, aDouble) -> matrix.put(s, aDouble * value));
    }

    public void divide(Double value) {
        matrix.forEach((s, aDouble) -> matrix.put(s, aDouble / value));
    }
}
