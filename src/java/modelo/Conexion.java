/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    Connection cnn;
    Statement state;
    ResultSet res;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insertarC(Usuario C){
        int bandera=0;
        try {
            String query = "insert into usuarios(UserID, UserName, Password, Email)"
                    +"values("+C.getUserID()+",'"+C.getUserName()+"','"+C.getPassword()+"','"+C.getEmail()+"')";
            
            state = cnn.createStatement();
            state.executeUpdate(query);
            bandera =state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandera;
    }
    public int insertarP(Producto P){
        int bandera=0;
        try {
            String query = "insert into producto(nombre, marca, cantidad, precio)"
                    +"values("+P.getNombre()+",'"+P.getMarca()+"','"+P.getCantidad()+"','"+P.getPrecio()+"')";
            
            state = cnn.createStatement();
            state.executeUpdate(query);
            bandera =state.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandera;
    }
    public ResultSet ConsultarTodoUS(){
        try {
            String query = "select* from usuarios";
            state = cnn.createStatement();
            res = state.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public ResultSet ConsultarTodoProd(){
        try {
            String query = "select * from producto";
            state = cnn.createStatement();
            res = state.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    public int ExisteUsuario(String usuario){
        PreparedStatement ps =null;
        res=null;
        
        String query = "SELECT count(UserName) From usuarios where UserName ='?'";

            try {
                ps=cnn.prepareStatement(query);
                ps.setString(1, usuario);
                res=ps.executeQuery();
                
                if (res.next()) {
                    return res.getInt(1);
                }
                return 1;
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 1;
        }
    public boolean login(Usuario U){
        PreparedStatement ps =null;
        res=null;
        String query = "SELECT UserID, UserName, Password, Email FROM usuarios WHERE UserName = '?'";
        

            try {
                ps = cnn.prepareStatement(query);
                ps.setString(1, U.getUserName());
                res = ps.executeQuery();
                
                if (res.next()) {
                    if(U.getPassword().equals(res.getString(3))){
                        String queryUpdate = "Update usuarios SET last_session = '?'"
                                + "WHERE UserName='?'";
                        ps =cnn.prepareStatement(queryUpdate);
                        ps.setString(1, U.getDate());
                        ps.setInt(2, res.getInt(1));
                        ps.execute();
                        U.setUserID(res.getInt(1));
                        U.setEmail(res.getString(4));
                        return true;
                    }else{
                           return false;
                    }
                }
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
      return false;
    }

    private Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
