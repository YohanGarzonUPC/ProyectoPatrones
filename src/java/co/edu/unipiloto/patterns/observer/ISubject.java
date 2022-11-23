/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.patterns.observer;

/**
 *
 * @author USUARIO
 */
public interface ISubject {
    void register(Observer o);

    void unregister(Observer o);

    void notifyObservers();
}
