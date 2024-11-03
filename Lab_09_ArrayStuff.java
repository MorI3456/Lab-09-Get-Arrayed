import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {

    public static void main(String[] args) {
        int[] dataPoints = new int[100];

        Random rnd = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = sum / (double) dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);

        Scanner scanner = new Scanner(System.in);
        int searchValue = getRangedInt(scanner, "Enter a value between 1 and 100: ", 1, 100);

        int count = 0;
        for (int value : dataPoints) {
            if (value == searchValue) {
                count++;
            }
        }
        System.out.println("The value " + searchValue + " was found " + count + " times in the array.");

        int searchValue2 = getRangedInt(scanner, "Enter another value between 1 and 100: ", 1, 100);
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue2) {
                System.out.println("The value " + searchValue2 + " was found at array index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The value " + searchValue2 + " was not found in the array.");
        }

        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int value : dataPoints) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println("The minimum value in the array is: " + min);
        System.out.println("The maximum value in the array is: " + max);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / (double) values.length;
    }

    public static int getRangedInt(Scanner scanner, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            input = scanner.nextInt();
        } while (input < low || input > high);
        return input;
    }
}
