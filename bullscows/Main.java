package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int[] secretCode = {2, 1, 3, 7};

    public static int[] getPlayerGuess() {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            input = scanner.nextInt();
        } while (input <= 999 || input >= 10000);

        int[] guess = new int[4];
        guess[0] = input / 1000;
        input -= (input / 1000) * 1000;
        guess[1] = input / 100;
        input -= (input / 100) * 100;
        guess[2] = input / 10;
        input -= (input / 10) * 10;
        guess[3] = input;

        return guess;
    }

    public static void gradePlayerGuess(int[] guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secretCode.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                if (i == j && secretCode[i] == guess[j]) {
                    bulls++;
                } else if (secretCode[i] == guess[j]) {
                    cows++;
                }
            }
        }

        if (cows != 0 && bulls != 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secretCode[0] + secretCode[1] + secretCode[2] + secretCode[3]);
        } else if (cows != 0) {
            System.out.println("Grade: " + cows + " cow(s). The secret code is " + secretCode[0] + secretCode[1] + secretCode[2] + secretCode[3]);
        } else if (bulls != 0) {
            System.out.println("Grade: " + bulls + " bull(s). The secret code is " + secretCode[0] + secretCode[1] + secretCode[2] + secretCode[3]);
        } else {
            System.out.println("Grade: None. The secret code is " + secretCode[0] + secretCode[1] + secretCode[2] + secretCode[3]);
        }
    }

    public static void generateSecretCode() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        StringBuilder code = new StringBuilder();

        if (size > 0 && size < 11) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i < 10; i++) list.add(i);
            Collections.shuffle(list);
            for (int i = 0; i < size; i++) code.append(list.get(i));
            System.out.printf("The random secret number is %s.", code);
        } else {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }

    }

    public static void main(String[] args) {
        //gradePlayerGuess(getPlayerGuess());
        generateSecretCode();
    }
}