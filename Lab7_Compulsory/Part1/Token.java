package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Token {
    Token size;
    private List<Token> tokens = new ArrayList<>();

    public Token (Token size) { this.size = size; }

    public static boolean isCompleteArithmeticProgression(int[] tokens, int size) {
        if (size == 1)
            return true;

        // Sort array
        Arrays.sort(tokens);

        // After sorting, difference between
        // consecutive elements must be same.
        int d = tokens[1] - tokens[0];
        for (int i = 2; i < size; i++)
            if (tokens[i] - tokens[i - 1] != d)
                return false;

        return true;
    }

    public void createArithmeticProgression (int startingNumber, int commonDiference, int size) {
        int token;
        token = startingNumber;
        for (int i = 1; i <= size; i++)
        { System.out.print(token + " ");
            token = token + commonDiference;
        }
    }

    public boolean empty()
    {
        return tokens.isEmpty();
    }

    public void add(Token token)
    {
        tokens.add(token);
    }
}
