package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    /*cod adaptat dupa https://profs.info.uaic.ro/~acf/java/slides/en/networking_slide_en.pdf */
    private static String SERVER_ADDRESS = "127.0.0.1";
    private static int PORT = 8100;
    Socket socket = null;

    public GameClient() throws IOException {
        this.socket = new Socket(SERVER_ADDRESS, PORT);
    }

    String readKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void sendRequest(String request) throws IOException {
    }

    public void receiveResponse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = in.readLine();
        if (response != null) {
            System.out.println(response);
        }
    }
}
