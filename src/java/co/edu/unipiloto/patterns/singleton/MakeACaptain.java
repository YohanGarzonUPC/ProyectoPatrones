/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.singleton;

/**
 *
 * @author USUARIO
 */
public class MakeACaptain {

    private static MakeACaptain _captain;
//We make the constructor private to prevent the use of "new"

    private MakeACaptain() {
    }

    public static MakeACaptain getCaptain() {
// Lazy initialization
        if (_captain == null) {
            _captain = new MakeACaptain();
            System.out.println("New Captain selected for our team");
        } else {
            System.out.print("You already have a Captain for your team.");
            System.out.println("Send him for the toss.");
        }
        return _captain;
    }

}
