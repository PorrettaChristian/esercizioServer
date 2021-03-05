/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pogliani.mattia
 */
public class ServerThread implements Runnable {

    private Socket clientSocket;
    public static int num = 0;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
//        System.out.println("Serverino  partito: "
//                + clientSocket.getInetAddress());
        try
        {

//            PrintWriter out
//                    = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String n = "";
//            while (!richiesta.equals("exit")) {
            System.out.println("serverino in ascolto...");
            n = in.readLine();
            System.out.println("stringa dal client: " + n);
            int a = Integer.parseInt(n);
            Thread t = null;
            for (int i = 0; i < a; i++)
            {
                t = new Thread(new thread(i));
                t.start();
            }
            while(true){
                if(t.isAlive() == false){
                    System.out.println(num);
                    break;
                }
            }
        } catch (IOException ex)
        {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
