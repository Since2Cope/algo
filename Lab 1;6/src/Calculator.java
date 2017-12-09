import java.util.ArrayList;
import java.util.List;

public class Calculator {
    static double calculateFullStatement(List<String> statement) {
        double result;
        if ((statement.get(0).equals("П")
                && (statement.get(1).equals("("))
                && isDigit((statement.get(2)))
                && (statement.get(3).equals("-"))
                && isDigit((statement.get(4)))
                && (statement.get(5).equals(")"))
        )) {
            result = calculateMultiplication(statement,
                    Integer.parseInt(statement.get(2)),
                    Integer.parseInt(statement.get(4)));
        } else throw new ArithmeticException();
        return result;
    }

    private static double calculateMultiplication(List<String> fullStatement, int begin, int end) {
        List<String> statement = fullStatement.subList(6, fullStatement.size());
        List<Integer> positions = new ArrayList<>();
        double result = 1;
        for (int i = 0; i < statement.size(); i++) {//determination positions of variable
            if (statement.get(i).equals("i"))
                positions.add(i);
        }
//        System.out.println("statement = " + statement);
//        System.out.println("positions = " + positions);
        for (Integer i = begin; i <= end; i++) {
            for (int j = 0; j < positions.size(); j++) {
                statement.set(positions.get(j), i.toString());
            }
            double currentTurn = calculate(statement);
            result*=currentTurn;
//            System.out.println("result = " + result + "\ti = " + i);
//            System.out.println("currentTurn = " + currentTurn);
        }
        return result;
    }

    static double calculatePoland(List<String> statement) {
        int sizeOfStatement = statement.size();
        while (statement.size() != 1) {
            sizeOfStatement = statement.size();
            processStatement(statement);
            if (sizeOfStatement == statement.size()) {
                throw new IllegalArgumentException();
            }

        }
        return Double.parseDouble(statement.get(0));
    }

    static double calculate(List<String> initialStatement) {
        List<String>statement = new ArrayList<>(initialStatement);
        //(3+4)*8+12/(4-2)
//        checkingPrime(statement);
        ArrayList<String> processStatement = new ArrayList<>();
        int statementSize = 0;//no 0
        int begin = 0;
        int end;
        while (statement.size() != statementSize) {
            statementSize = statement.size();
            for (int i = 0; i < statement.size(); i++) {
                if (statement.get(i).equals("sin"))
                    calculateSin(statement, i);
                if (statement.get(i).equals("("))
                    begin = i;
                if (statement.get(i).equals(")")) {
                    end = i;
//                    processScope(statement, begin, end);
                    statement.remove(end);
                    statement.remove(begin);
                    calculatePart(begin, end - 2, statement);
                    break;
                }
            }
        }
        if (statement.size() > 1)
            return calculateStatementWithoutScopes(statement);
        else
            return Double.parseDouble(statement.get(0));
    }

    private static void calculateSin(List<String> statement, int i) {
        if (isDigit(statement.get(i + 1))) {
            Double result = Math.sin(Double.parseDouble(statement.get(i + 1)));
            statement.remove(i + 1);
            statement.set(i, result.toString());
        } else
            return;
    }

    private static Double calculateStatementWithoutScopes(List<String> statement) {
        if (statement.size() == 1)
            return Double.parseDouble(statement.get(0));
        int statementSize = 0;//to do
        while (statementSize != statement.size()) {
            statementSize = statement.size();
            for (int i = 0; i < statement.size(); i++) {
                if (statement.get(i).equals("*") || statement.get(i).equals("/")|| statement.get(i).equals("^")) {
                    Double newElement = doAction(statement.get(i - 1), statement.get(i + 1), statement.get(i));
                    statement.remove(i + 1);
                    statement.remove(i);
                    statement.remove(i - 1);
                    statement.add(i - 1, newElement.toString());
                    break;
                }
            }
        }
        statementSize = 0;
        while (statementSize != statement.size()) {
            statementSize = statement.size();
            for (int i = 0; i < statement.size(); i++) {
                if (statement.get(i).equals("+") || statement.get(i).equals("-")) {
                    Double newElement = doAction(statement.get(i - 1), statement.get(i + 1), statement.get(i));
                    statement.remove(i + 1);
                    statement.remove(i);
                    statement.remove(i - 1);
                    statement.add(i - 1, newElement.toString());
                    break;
                }
            }
        }
        if (statement.size() > 1)
            throw new ArithmeticException();
        else return Double.parseDouble(statement.get(0));
    }

    private static void calculatePart(int i, int j, List<String> statement) {
        List<String> reverseStatement = new ArrayList<>();
        for (int k = j; k >= i; k--) {
            reverseStatement.add(statement.get(k));
            statement.remove(k);
        }
        List<String> partOfStatement = new ArrayList<>();
        for (int k = reverseStatement.size() - 1; k >= 0; k--) {
            partOfStatement.add(reverseStatement.get(k));
        }
        statement.add(i, calculateStatementWithoutScopes(partOfStatement).toString());
    }

    private static void processStatement(List<String> statement) {
        for (int i = 0; i < statement.size(); i++) {
            if (!isDigit(statement.get(i))) {
                Double newElement =
                        doAction(statement.get(i - 2), statement.get(i - 1), statement.get(i));
                statement.remove(i);
                statement.remove(i - 1);
                statement.remove(i - 2);
                statement.add(i - 2, newElement.toString());
                break;
            }
        }
    }

    public static boolean isDigit(String statement) {
        try {
            Double.parseDouble(statement);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    private static double doAction(String x, String y, String operator) {
        double a = Double.parseDouble(x);
        double b = Double.parseDouble(y);
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return Math.pow(a, b);
            default:
                throw new ArithmeticException();
        }
    }

    public static boolean isPrime(int number) {

        // fast even test.
        if (number > 2 && (number & 1) == 0)
            return false;
        // only odd factors need to be tested up to n^0.5
        for (int i = 3; i * i <= number; i += 2)
            if (number % i == 0)
                return false;
        return true;
    }

    public static void checkingPrime(List<String> statement) {
//        statement.stream().filter(x->isDigit(x)).filter(x->!isPrime(Integer.parseInt(x))).forEach(System.out::println);
        if (statement.stream().filter(x -> isDigit(x)).filter(x -> !isPrime(Integer.parseInt(x))).count() > 0)
            throw new ArithmeticException();
    }
}