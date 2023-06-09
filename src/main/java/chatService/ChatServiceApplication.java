package chatService;

import multithread.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServiceApplication {
    public static void main(String[] args) throws IOException {
        MessageQueue queue = new MessageQueue();
        ServerSocket welcomeSocket = new ServerSocket(6789);

        System.out.println("waiting for requests...");

        while(true){
            try {
                Socket connectionSocket = null;
                connectionSocket = welcomeSocket.accept();

                System.out.println("client connected");
                // thread creation passing the established socket as arg
                Thread theThread =
                        new ChatService(connectionSocket, queue);

                // start of the thread
                theThread.start();
;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
