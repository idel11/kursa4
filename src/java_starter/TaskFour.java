package java_starter;

import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {

        System.out.print("Введіть дату: ");
        Scanner sc = new Scanner(System.in);
        String date = sc.next();

        String digits = date.replaceAll("[^0-9]", "");

        int sum = 0;

        for (char c : digits.toCharArray()) {
            int d = Character.getNumericValue(c);
            sum += d;
        }

        System.out.println(sum);
    }
}
