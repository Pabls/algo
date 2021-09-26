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

            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for(int j = 0; j < digits.length; j++) {
                int tmpIndex = j - 1;
                while (tmpIndex >= 0 && digits[tmpIndex] > digits[tmpIndex + 1]) {
                    int tmp = digits[tmpIndex];
                    digits[tmpIndex] = digits[tmpIndex + 1];
                    digits[tmpIndex + 1] = tmp;
                    tmpIndex -= 1;
                }
                if((tmpIndex + 1) != j) {
                    writer.write("Swap elements at indices " + (tmpIndex + 2) + " and " + (j + 1) + ".");
                    writer.newLine();
                }
            }
            writer.write("No more swaps needed.");
            writer.close();


            for(int i = 0; i < strings.length; i++) {
                System.out.println(digits[i]);
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}