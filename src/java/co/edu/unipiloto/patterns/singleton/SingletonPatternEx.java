/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class SingletonPatternEx {

    public static void main(String[] args) {
        System.out.println("***Singleton Pattern Demo***\n");
        System.out.println("Trying to make a captain for our team");
        MakeACaptain c1 = MakeACaptain.getCaptain();
        System.out.println("Trying to make another captain for our team");
        MakeACaptain c2 = MakeACaptain.getCaptain();
        if (c1 == c2) {
            System.out.println("c1 and c2 are same instance");
        }

        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        int edad=0;
        String nombre="";
        try {
            edad=bufferedreader.read();
            nombre= bufferedreader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(SingletonPatternEx.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Nombre "+ nombre+" Edad "+ edad);
        
  

        
        
    }

}
