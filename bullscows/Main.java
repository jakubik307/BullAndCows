package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static StringBuilder secretCode = new StringBuilder();
    static int turn = 1;

    public static StringBuilder getPlayerGuess() {
        System.out.println("Turn " + turn + ":");
        turn++;

        Scanner scanner = new Scanner(System.in);
        StringBuilder guess = new StringBuilder();

        guess.append(scanner.next());
        return guess;
    }

    public static boolean gradePlayerGuess(StringBuilder guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secretCode.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (i == j && secretCode.charAt(i) == guess.charAt(j)) {
                    bulls++;
                } else if (secretCode.charAt(i) == guess.charAt(j)) {
                    cows++;
                }
            }
        }

        if (bulls == secretCode.length()) {
            System.out.println("Grade: " + bulls + " bull(s).");
            System.out.println("Congratulations! You guessed the secret code.");
            return false;
        } else if (cows != 0 && bulls != 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            return true;
        } else if (cows != 0) {
            System.out.println("Grade: " + cows + " cow(s).");
            return true;
        } else if (bulls != 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
            return true;
        } else {
            System.out.println("Grade: None.");
            return true;
        }
    }

    public static void generateSecretCode() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        if (size > 0 && size < 10) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i < 10; i++) list.add(i);
            Collections.shuffle(list);
            for (int i = 0; i < size; i++) secretCode.append(list.get(i));
            System.out.println("Okay, let's start a game!");
        } else {
            System.out.println("Error: can't generate a secret number with a length of" + size + "because there aren't enough unique digits.");
        }

    }

    public static void main(String[] args) {
        generateSecretCode();
        while (gradePlayerGuess(getPlayerGuess())) ;
    }
}