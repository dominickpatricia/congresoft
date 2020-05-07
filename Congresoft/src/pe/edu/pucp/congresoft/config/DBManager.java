/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.config;

/**
 *
 * 
 */
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
*/

public class DBManager {
    public static String driverName = "com.mysql.cj.jdbc.Driver";
    public static String url ="lp2mysql.csoxckc5s8uc.us-east-1.rds.amazonaws.com";
    public static String password ="abcd1234";
    public static String username="admin";
    public static String rutaDrive="jdbc:mysql://";
    public static String puerto_db =":3306/inf282";
    /*
    private Connection con;
    
    //constructor 
    public DBManager(){
        
    }
    
    //metodos
    public void crearConexion(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
              this.con = DriverManager.
          getConnection("jdbc:mysql://"+
         "lp2mysql.csoxckc5s8uc.us-east-1.rds.amazonaws.com"+
                  ":3306/inf282", "admin", "abcd1234");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public ResultSet resultadoQuery(String sentencia){
        
        try{
        String sentenciabd ="SELECT * FROM CONGRESO";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sentencia);
        return rs;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public void resultadoUpdate(String sentencia){
    
    }*/
}
