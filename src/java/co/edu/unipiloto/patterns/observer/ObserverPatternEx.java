/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.observer;

/**
 *
 * @author USUARIO
 */
   class ObserverPatternEx {

        public static void main(String[] args) {
            System.out.println("***Observer Pattern Demo***\n");
            Observer o1 = new Observer();
            Subject sub1 = new Subject();
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

