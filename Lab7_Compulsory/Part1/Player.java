package com.company;

public class Player implements Runnable {
    private String name;
    private Game game;
    private Token token;
    private int totalScore;

    Player(String name){ this.name=name; }
    String getName() { return name; }
    int getTotalScore() { return totalScore; }
    void setTotalScore(int score) {
        totalScore += score;
    }

    public void setGame(Game g) { game = g; }

    private boolean play() throws InterruptedException {
        Board board = game.getBoard();
        if(token == null) token = new Token(board.token);
        if (board.isEmpty() || game.isEnded()) {
            return false;
        }
        token.add(board.extract());
        Thread.sleep(100); /*thinking time*/
        if (Token.isCompleteArithmeticProgression()) {
            game.setWinner(this);
        }
        return true;
    }

    public void run()
    { try {
        while (this.play()){
            System.out.println(this);
        }
    }
    catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", totalScore=" + totalScore +
                '}';
    }
}