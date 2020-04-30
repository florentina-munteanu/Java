package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        while(true) {
            String request = client.readKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                client.sendRequest(request);
                client.receiveResponse();
            }
        }
    }
}
