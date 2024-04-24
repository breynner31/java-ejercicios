/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.math.rmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Holly
 */
public class MathClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            MathOperations mathServer = (MathOperations) registry.lookup("MathServer");

            double a = 10;
            double b = 5;

            double suma = mathServer.add(a, b);
            double resta = mathServer.subtract(a, b);
            double multiplicacion = mathServer.multiply(a, b);
            double division = mathServer.divide(a, b);

            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicacion: " + multiplicacion);
            System.out.println("Division: " + division);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
