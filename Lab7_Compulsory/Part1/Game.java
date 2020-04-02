package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private Board board;
    private final List<Player> players = new ArrayList<>();
    private String winner = null;

    private static ExecutorService executorService = Executors.newFixedThreadPool(8);

    //Create getters and setters
    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public void setBoard(Board b){ board = b; }

    public Board getBoard(){ return board; }

    public synchronized void setWinner(Player p){
        if(winner == null){
            winner = p.toString();
        }
    }

    //Create the method that will start the game: start one thread for each player
    public void start() throws InterruptedException {
        for(Player p : players) {
            executorService.execute((java.lang.Runnable) p);
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){
            Thread.sleep(50);
        }
        System.out.println("Winner is" + winner);
    }

    public boolean isEnded() { return winner != null; }

   public void displayGameMenu() {
        System.out.println();
        System.out.println("(1) Start a new game");
        System.out.println("(2) Exit game");
        System.out.print("Choose an option: ");
    }

    /*public void selectGameOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                this.start();
                break;
            default:
                break;
        }
    }*/

   /* public void startNewGame() {
        String p1Name;
        String p2Name;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter player one name: ");
        p1Name = sc.nextLine();
        System.out.print("Please enter player two name: ");
        p2Name = sc.nextLine();
    }*/
}
