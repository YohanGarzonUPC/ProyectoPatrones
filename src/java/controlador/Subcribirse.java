/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import co.edu.unipiloto.patterns.observer.Observer;
import modelo.Usuario;

/**
 *
 * @author Kevin Emiro Ospinal
 */
public class Subcribirse {

    public static void subribirse() {
        Observer o1 = new Observer();
        Usuario sub1 = new Usuario(0, "", "", "");
        sub1.register(o1);
        System.out.println("Setting Flag = 5 ");
        sub1.setFlag(5);
        System.out.println("Setting Flag = 25 ");
        sub1.setFlag(25);
        sub1.unregister(o1);
//No notification this time to o1 .Since it is unregistered.
        System.out.println("Setting Flag = 50 ");
        sub1.setFlag(50);
    }

}
