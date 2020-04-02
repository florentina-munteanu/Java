package com.company;

public class Board {
    public Token token;

    public Board(int token){
        this.token = token;
        token = new Token(token);
        token.createA
    }

    public boolean isEmpty() {
        return token.empty();
    }

    public synchronized Token extract() {

    }
}
