/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.congresoft.model;

import java.util.Date;

/**
 *
 * 
 */
public class Congreso {
    private static int idCongresoCont =3;
    private int idCongreso;
    private String nombre;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String pais;
    private int activo;
    
    //constructores
    public Congreso(){
        
    }
    public Congreso(String nombre, Date fecha_inicio, Date fecha_fin, String pais, int activo){
        this.activo=activo;
        this.fecha_fin=fecha_fin;
        this.fecha_inicio=fecha_inicio;
        this.pais=pais;
        this.nombre=nombre;
        Congreso.idCongresoCont ++;
        this.idCongreso=Congreso.idCongresoCont;
    }
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getIdCongreso() {
        return idCongreso;
    }

    public void setIdCongreso(int idCongreso) {
        this.idCongreso = idCongreso;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    //metodos

    public String mostrarDatos(){
        return this.idCongreso + " " + this.nombre+ " - "  +this.fecha_inicio + " - "+ this.fecha_fin +" -  " + this.pais ;
    }
}
