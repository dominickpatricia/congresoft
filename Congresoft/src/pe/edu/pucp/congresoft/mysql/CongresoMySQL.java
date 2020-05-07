/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import pe.edu.pucp.congresoft.config.DBManager;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;

/**
 *
 * 
 */
public class CongresoMySQL implements CongresoDAO {

    @Override
    public int insertar(Congreso congreso) {
       
       try {
           //conexion
            Class.forName(DBManager.driverName);
            Connection con = DriverManager.
            getConnection(DBManager.rutaDrive+ DBManager.url +
                DBManager.puerto_db, DBManager.username, DBManager.password);
            
            //insersion
            String sentencia="INSERT INTO CONGRESO(NOMBRE,FECHA_INICIO,FECHA_FIN,PAIS,ACTIVO)"+ "VALUES(?,?,?,?,?)";
            Statement st=con.createStatement();
         
            PreparedStatement ps=con.prepareStatement(sentencia);
            ps.setString(1, congreso.getNombre());
            ps.setDate(2,new java.sql.Date(congreso.getFecha_inicio().getTime()));
            ps.setDate(3,new java.sql.Date(congreso.getFecha_fin().getTime()));
            ps.setString(4, congreso.getPais());
            ps.setInt(5, congreso.getActivo());
           
            
            ps.execute();
            
            con.close();
           /* sentencia= "INSERT INTO CONGRESO(ID_CONGRESO,NOMBRE,FECHA_INICIO,FECHA_FIN,PAIS,ACTIVO) VALUES(" + 
                    congreso.getIdCongreso() +"," + congreso.getNombre() +"," + 
                    congreso.getFecha_inicio() + 
                    ", "+ congreso.getFecha_fin() + 
                    ","+ congreso.getPais() +","+ congreso.getPais() + ");";
            
            Statement st = con.createStatement();
            st.executeUpdate(sentencia);
            
            
            PreparedStatement ps=con.prepareStatement(sentencia);
            ps.setString(1, congreso.getNombre());
            ps.setDate(2,new java.sql.Date(congreso.getFecha_inicio().getTime()));
            ps.setDate(3,new java.sql.Date(congreso.getFecha_fin().getTime()));
            ps.setString(4, congreso.getPais());
            ps.setInt(5, congreso.getActivo());
            
            */
            return 1;
        
       
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return -1;
        }
        
    }

    @Override
    public ArrayList<Congreso> listar() {
        ArrayList<Congreso> congresoList = new ArrayList<>();
        try{
            
            //Conexion
          /*  Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.
          getConnection("jdbc:mysql://"+
         "lp2mysql.csoxckc5s8uc.us-east-1.rds.amazonaws.com"+
                  ":3306/inf282", "admin", "abcd1234");*/
             
             Class.forName(DBManager.driverName);
             Connection con = DriverManager.
          getConnection(DBManager.rutaDrive+ DBManager.url +
                  DBManager.puerto_db, DBManager.username, DBManager.password);
             
             
             //Sentencia
             String sentenciabd ="SELECT * FROM CONGRESO";
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sentenciabd);
             
           
           /*DBManager conexionBd = new DBManager();
           conexionBd.crearConexion();
           ResultSet rs =conexionBd.resultadoQuery("SELECT * FROM CONGRESO");
             */
           while(rs.next()){
                Congreso congreso = new Congreso();
                congreso.setIdCongreso(rs.getInt("ID_CONGRESO"));
                congreso.setNombre(rs.getString("NOMBRE"));
                congreso.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                congreso.setFecha_fin(rs.getDate("FECHA_FIN"));
                congreso.setPais(rs.getString("PAIS"));
                congreso.setActivo(rs.getInt("ACTIVO"));
                
                congresoList.add(congreso);
            }
             
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return congresoList;
    }
    
}
