/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.congresoft.dao.CongresoDAO;
import pe.edu.pucp.congresoft.model.Congreso;
import pe.edu.pucp.congresoft.mysql.CongresoMySQL;

/**
 *
 
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
       
        //Para listar//
        ArrayList<Congreso> congresos  = new ArrayList<>();
        CongresoDAO daoCongreso = 
                new CongresoMySQL();
        
        congresos = daoCongreso.listar();
        
        for(Congreso c : congresos){
            System.out.println(c.mostrarDatos());
        }
        
        //Para insertar//
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Congreso congreso1 = new Congreso("Congreso n2", sdf.parse("01-01-2019"), sdf.parse("05-05-2019"),"Peru",1);
        //CongresoDAO daoCongreso = new CongresoMySQL();
        daoCongreso.insertar(congreso1);
        
        
    }
    
}
