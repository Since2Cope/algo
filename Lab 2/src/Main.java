import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        String filename = "1.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready())
                string.append(bufferedReader.readLine()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = reverse(string.toString());
        try (PrintWriter writer = new PrintWriter(filename)){
            writer.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static String reverse(String string) {
        String result = "";
        for (int i = string.length()-1; i>=0;i--)
            result+=string.charAt(i);
        return result;
    }
}
