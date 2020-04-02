package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.setBoard(new Board(10));
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.start();

        Game game = new Game();

        int optionSelected;

        while (true) {
            game.displayGameMenu();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            optionSelected = sc.nextInt();

            while (optionSelected > 2 || optionSelected < 0) {

                System.out.print("Option entered invalid, please enter a number from 1 to 2: ");
                optionSelected = sc.nextInt();
            }

            if (optionSelected == 2) {
                System.out.println("Exiting game");
                break;
            }

           /* game.selectGameOption(optionSelected); */
        }
    }
}
