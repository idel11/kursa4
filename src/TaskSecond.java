import java.util.ArrayList;
import java.util.Scanner;

public class TaskSecond {

    public static void main(String[] args) {

        System.out.print("Введіть число: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        ArrayList<Integer> array = new ArrayList<Integer>();
        do{
            array.add(number % 10);
            number /= 10;
        } while  (number > 0);

        if (array.contains(0)) {
            System.out.println("Ваш масив має нулі");
        } else System.out.println(array);

    }

}
