import java.util.Arrays;

public class Vector {
    private double[] values;

    public Vector(double[] values) {
        this.values = values;
    }


    public void plus(Double value) {
        for (int i = 0; i < values.length; i++) {
            values[i] += value;
        }
    }

    public void minus(Double value) {
        for (int i = 0; i < values.length; i++) {
            values[i] -= value;
        }
    }

    public void multiply(Double value) {
        for (int i = 0; i < values.length; i++) {
            values[i] *= value;
        }
    }

    public void divide(Double value) {
        for (int i = 0; i < values.length; i++) {
            values[i] /= value;
        }
    }

    public void output() {
        System.out.print(Arrays.toString(values));
    }
}
