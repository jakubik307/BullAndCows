package bullscows;

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

    public static void main(String[] args) {
        gradePlayerGuess(getPlayerGuess());
    }
}