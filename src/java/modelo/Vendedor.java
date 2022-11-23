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
public class Vendedor extends Usuario{
    
    private double ganancias;
    public DoubleLLI Catalogo;
    
    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public DoubleLLI getCatalogo() {
        return Catalogo;
    }

    public void setCatalogo(DoubleLLI Catalogo) {
        this.Catalogo = Catalogo;
    }

    public Vendedor(double ganancias, DoubleLLI Catalogo, int UserID, String UserName, String Password, String Email) {
        super(UserID, UserName, Password, Email);
        this.ganancias = ganancias;
        this.Catalogo = Catalogo;
    }
}
