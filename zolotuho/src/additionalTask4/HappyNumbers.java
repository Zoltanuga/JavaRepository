package additionalTask4;

import java.util.Scanner;

//найти счастливые числа
public class HappyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three-digit number : ");
        int number = sc.nextInt();
        sc.close();
        int[] magicArray = new int[]{781, 302, 409, 941};
        boolean magicNumberPresence = false;
        for (int i : magicArray) {
            if (i == number) {
                magicNumberPresence = true;
            }
        }
        if (magicNumberPresence == true) {
            System.out.println("Magic");
        } else {
            int[] digits = new int[3];
            int counter = 0;
            int auxiliaryNum = number;
            while (auxiliaryNum % 10 != 0) {
                auxiliaryNum /= 10;
                counter++;
            }
            if (counter == 3) {
                for (int i = 0; i < counter; i++) {
                    digits[i] = number % 10;
                    number -= digits[i];
                    number /= 10;
                }
                int flagHappyEqual = 0;
                int flagHappyGrow = 0;
                for (int i = 0; i < counter - 1; i++) {
                    if (digits[i] == digits[i + 1]) {
                        flagHappyEqual++;
                    }
                    if (digits[i] - digits[i + 1] == 1) {
                        flagHappyGrow++;
                    }
                }
                if ((flagHappyEqual == 2) || (flagHappyGrow == 2)) {
                    System.out.println("Happy");
                } else {
                    System.out.println("Not happy");
                }
            } else {
                System.out.println("Number is too big or small");
            }
        }
    }
}