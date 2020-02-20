/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.PeliculasSeries;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author lala
 */
@Named(value = "peliculasSeriesBean")
@SessionScoped
public class PeliculasSeriesBean implements Serializable {
    
    private ArrayList<PeliculasSeries> listadopeliculas = null;
    private ArrayList<PeliculasSeries> listadopeliculaseliminadas = new ArrayList<>();
    private int calificacion;
    private PeliculasSeries peliculasdetalles;
    
       
    /**
     * Creates a new instance of PeliculasSeriesBean
     */
    @PostConstruct
    public void init(){
        listadopeliculas = new ArrayList<PeliculasSeries>();
        
        listadopeliculas.add(new PeliculasSeries(4,"pelicula 4", 
                "descripcion 4", 4.0,"2020", "director 4", "reparto 4", true));
        listadopeliculas.add(new PeliculasSeries(5,"pelicula 5", 
                "descripcion 5", 2.0,"2018", "director 5", "reparto 4", true));
        listadopeliculas.add(new PeliculasSeries(6,"pelicula 6", 
                "descripcion 6", 3,"2017", "director 7", "reparto 4", true));
        listadopeliculas.add(new PeliculasSeries(5,"serie 5", 
                "descripcion 5", 2.0,"2018", "director 5", "reparto 5", false));
        listadopeliculas.add(new PeliculasSeries(6,"serie 6", 
                "descripcion 6", 3,"2017", "director 7", "reparto 4", false));
        peliculasdetalles = new PeliculasSeries();
    }
    public PeliculasSeriesBean() {
        
    }
    public String eliminar(){
        for (PeliculasSeries p : listadopeliculas) {
            if(p.isSelected()){
                listadopeliculaseliminadas.add(p);
                
            }
        }
        if(!listadopeliculaseliminadas.isEmpty()){
            listadopeliculas.removeAll(listadopeliculaseliminadas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado!!!"));
        }
        return "index";
    }
    public void actualizar(RowEditEvent event){
        PeliculasSeries p = (PeliculasSeries) event.getObject();
        p.setCalificacion(calificacion);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actulizado!!!"));

    }
    public void cancelar(RowEditEvent event){
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancelado!!!"));
 
    }
    public void seleccionar(PeliculasSeries p){
        peliculasdetalles=p;
       
    }

    /**
     * @return the listadopeliculas
     */
    public ArrayList<PeliculasSeries> getListadopeliculas() {
        return listadopeliculas;
    }

    /**
     * @param listadopeliculas the listadopeliculas to set
     */
    public void setListadopeliculas(ArrayList<PeliculasSeries> listadopeliculas) {
        this.listadopeliculas = listadopeliculas;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the peliculasdetalles
     */
    public PeliculasSeries getPeliculasdetalles() {
        return peliculasdetalles;
    }

    /**
     * @param peliculasdetalles the peliculasdetalles to set
     */
    public void setPeliculasdetalles(PeliculasSeries peliculasdetalles) {
        this.peliculasdetalles = peliculasdetalles;
    }

   

    
    

    
}
