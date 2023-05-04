package pw1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input numb: ");
        int n = in.nextInt();

        Predicate<Integer> isEvenNumber = num -> {
            while (num % 2 == 0 && num > 0) {
                num = num / 2;
            }
            return num == 1;
        };
        System.out.println(isEvenNumber.test(n));
    }
}
