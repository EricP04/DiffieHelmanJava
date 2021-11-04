/*
 * Copyright (c) Paque Eric Ugo
 */

package TestLocal;

import DiffieHellman.DiffieHellman;
import DiffieHellman.NP;

import java.math.BigInteger;

public class TestLocal {

    public static void main(String[] args) {
        NP np = DiffieHellman.generateNP(1,100000);
        System.out.println(np);
        BigInteger x = DiffieHellman.generateRandomNumber();
        System.out.println("X = " +x );
        BigInteger publicKey = DiffieHellman.getKey(np.getN(), np.getP(), x);
        System.out.println("Public Key : " + publicKey);

        System.out.println("TEST AVEC COURS");
        BigInteger n = BigInteger.valueOf(7), p = BigInteger.valueOf(11);
        BigInteger A = BigInteger.valueOf(3), B = BigInteger.valueOf(6);
        BigInteger alpha = DiffieHellman.getKey(n,p,A);
        BigInteger beta = DiffieHellman.getKey(n,p,B);
        System.out.println("Alpha : " + alpha);
        System.out.println("Beta : " + beta);
        BigInteger privateKeyJames = DiffieHellman.getKey(beta,p,A);
        BigInteger privateKeyFrancesca=DiffieHellman.getKey(alpha,p,B);
        System.out.println("PrivateKey James :" + privateKeyJames);
        System.out.println("PrivateKey Francesca : " + privateKeyFrancesca);
    }
}
