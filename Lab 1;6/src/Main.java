import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
//            String[] stringStatement = ("( -2 * ( 19 + 7 ) / 11 * 5 - 11 )").split(" ");
            String [] stringStatement = ("П ( 2 - 3 ) sin i / ( ( i - 1 ) ^ 2 )").split(" ");
            List<String> statement = new ArrayList<>();
            Collections.addAll(statement, stringStatement);
            System.out.println(Calculator.calculateFullStatement(statement));
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        long startTime = System.currentTimeMillis();
        Matrix matrix = new Matrix();
        matrix.output();
        matrix.plus(5d);
        System.out.println();
        matrix.output();
        System.out.println();
        matrix.divide(2d);
        matrix.output();
        long endTime = System.currentTimeMillis();
        Vector vector = new Vector(new double[]{(int)5.5, 5d, 7d});
        vector.plus(5d);
        vector.output();
        System.out.println();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        System.out.println("Size of matrix:\t"+ ObjectSizeCalculator.getObjectSize(matrix));
    }

    static List<String> getStatementFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter statement");
        String[] stringStatement = scanner.nextLine().split(" ");
        List<String> statement = new ArrayList<>();
        Collections.addAll(statement, stringStatement);
        return statement;
    }
}
