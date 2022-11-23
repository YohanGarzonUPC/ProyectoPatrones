/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import estructuraD.DoubleLLI;

/**
 *
 * @author USUARIO
 */
public class Cliente extends Usuario{
    
    private int numeroTarjeta;
    private double dinero;
    public DoubleLLI carro;

    public Cliente(int numeroTarjeta, double dinero, DoubleLLI carro, int UserID, String UserName, String Password, String Email) {
        super(UserID, UserName, Password, Email);
        this.numeroTarjeta = numeroTarjeta;
        this.dinero = dinero;
        this.carro = carro;
    }

    public DoubleLLI getCarro() {
        return carro;
    }

    public void setCarro(DoubleLLI carro) {
        this.carro = carro;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
}
