import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner inputScanner = new Scanner(inputFile);

            int arraySize = Integer.valueOf(inputScanner.nextLine()).intValue();
            String[] strings = inputScanner.nextLine().split(" ");

            int[] digits = new int[arraySize];

            for(int i = 0; i < strings.length; i++) {
                digits[i] = Integer.valueOf(strings[i]).intValue();
            }

            for(int j = 0; j < digits.length; j++) {
                int tmpIndex = j - 1;
                while (tmpIndex >= 0 && digits[tmpIndex] > digits[tmpIndex + 1]) {
                    int tmp = digits[tmpIndex];
                    digits[tmpIndex] = digits[tmpIndex + 1];
                    digits[tmpIndex + 1] = tmp;
                    tmpIndex -= 1;
                }
            }
        
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < strings.length; i++) {
                sb.append(digits[i]);
                sb.append(" ");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(sb.toString());
            writer.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}