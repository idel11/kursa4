import java.util.ArrayList;
import java.util.Scanner;

public class TaskFirst {
    public static void main(String[] args) {

        System.out.print("введіть число: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        ArrayList<Integer> array = new ArrayList<Integer>();
        do{
            array.add(number % 10);
            number /= 10;
        } while  (number > 0);

        //System.out.println(array);

        int sum = 0;

        for(int i=0; i< array.size(); i++) {
            sum = sum + array.get(i);
        }

        System.out.println("Сума всіх цифр введеного числа = " + sum);
    }
}
