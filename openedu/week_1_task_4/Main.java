import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner inputScanner = new Scanner(inputFile);

            int arraySize = Integer.valueOf(inputScanner.nextLine()).intValue();
            String[] strings = inputScanner.nextLine().split(" ");

            double[][] digits = new double[arraySize][2];

            for(int i = 0; i < strings.length; i++) {
                digits[i][0] = Double.valueOf(strings[i]).doubleValue();
                digits[i][1] = i + 1;
            }

            for(int j = 0; j < digits.length; j++) {
                int tmpIndex = j - 1;
                while (tmpIndex >= 0 && digits[tmpIndex][0] > digits[tmpIndex + 1][0]) {
                    double[] tmp = digits[tmpIndex];
                    digits[tmpIndex] = digits[tmpIndex + 1];
                    digits[tmpIndex + 1] = tmp;
                    tmpIndex -= 1;
                }
            }
            
            int min = (int) digits[0][1];
            int avg = (int) digits[arraySize / 2][1];
            int max = (int) digits[arraySize - 1][1];

            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(min + " " + avg + " " + max);
            writer.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}