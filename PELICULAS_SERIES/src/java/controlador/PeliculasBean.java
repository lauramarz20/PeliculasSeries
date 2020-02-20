/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author lala
 */
@Named(value = "peliculasBean")
@RequestScoped
public class PeliculasBean {

    @EJB
    private PeliculasSeriesFacade peliFacade;
    
    private List<Object[]> listado;
    private boolean selected;
    private List<PeliculasBean> listado_eliminados;
    
    
   
    /**
     * @return the listado
     */
    public List<Object[]> getListado() {
        return listado;
    }

    /**
     * @param listado the listado to set
     */
    public void setListado(List<Object[]> listado) {
        this.listado = listado;
    }
    /**
     * Creates a new instance of topPeliculas
     */
    public PeliculasBean() {
    }
    @PostConstruct
    public void llenarTablaPeliculaTodas(){
        listado=peliFacade.obtenerPeliculas();
                
    }
   

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
}

