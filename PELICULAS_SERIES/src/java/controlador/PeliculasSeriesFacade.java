/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.PeliculasSeries;

/**
 *
 * @author lala
 */
@Stateless
public class PeliculasSeriesFacade extends AbstractFacade<PeliculasSeries> {

    @PersistenceContext(unitName = "PELICULAS_SERIESPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeliculasSeriesFacade() {
        super(PeliculasSeries.class);
    }
    public List obtenerTopPeliculas(){ 
        Query q = em.createNativeQuery("select name, descripcion, calificacion, anio from public.peliculas_series where pelicula = true and calificacion >= 4 ORDER BY 3 DESC");
        List<Object[]> listado=q.getResultList();
        return listado;
    }
    
    public List obtenerTopSeries(){ 
        Query q = em.createNativeQuery("select name, descripcion, calificacion, anio from public.peliculas_series where pelicula = false and calificacion >= 4 ORDER BY 3 DESC");
        List<Object[]> listadoseries=q.getResultList();
        return listadoseries;
    }
    public List obtenerPeliculas(){ 
        Query q = em.createNativeQuery("select name, descripcion, calificacion, anio from public.peliculas_series  ORDER BY 1");
        List<Object[]> listadoseries=q.getResultList();
        return listadoseries;
    }
   
}
