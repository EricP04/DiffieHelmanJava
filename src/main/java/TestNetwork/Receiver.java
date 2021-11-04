/*
 * Copyright (c) Paque Eric Ugo
 */

package TestNetwork;

import DiffieHellmanNetwork.DiffieHellmanNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

    public static void main(String[] args) {
        try{
            System.out.println("RECEIVER");
            ServerSocket listener = new ServerSocket(9999);
            System.out.println("Attente de connexion");
            Socket socket = listener.accept();
            System.out.println("Accepte");
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            BigInteger secretKey = DiffieHellmanNetwork.getSecretKey(out,in,1,10000000,true);
            System.out.println("Secret key : " + secretKey.longValue());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
