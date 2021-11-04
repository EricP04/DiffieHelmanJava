/*
 * Copyright (c) Paque Eric Ugo
 */

package TestNetwork;

import DiffieHellmanNetwork.DiffieHellmanNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Sender {

    public static void main(String[] args) {
        try{
            System.out.println("SENDER");
            Socket socket = new Socket("localhost",9999);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            BigInteger secretKey = DiffieHellmanNetwork.getSecretKey(out,in,1,10000000,false);
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
