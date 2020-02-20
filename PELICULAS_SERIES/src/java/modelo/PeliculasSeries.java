/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author lala
 */
@Entity
@Table(name = "peliculas_series")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeliculasSeries.findAll", query = "SELECT p FROM PeliculasSeries p")
    , @NamedQuery(name = "PeliculasSeries.findById", query = "SELECT p FROM PeliculasSeries p WHERE p.id = :id")
    , @NamedQuery(name = "PeliculasSeries.findByName", query = "SELECT p FROM PeliculasSeries p WHERE p.name = :name")
    , @NamedQuery(name = "PeliculasSeries.findByDescripcion", query = "SELECT p FROM PeliculasSeries p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "PeliculasSeries.findByCalificacion", query = "SELECT p FROM PeliculasSeries p WHERE p.calificacion = :calificacion")
    , @NamedQuery(name = "PeliculasSeries.findByAnio", query = "SELECT p FROM PeliculasSeries p WHERE p.anio = :anio")
    , @NamedQuery(name = "PeliculasSeries.findByPais", query = "SELECT p FROM PeliculasSeries p WHERE p.pais = :pais")
    , @NamedQuery(name = "PeliculasSeries.findByDirector", query = "SELECT p FROM PeliculasSeries p WHERE p.director = :director")
    , @NamedQuery(name = "PeliculasSeries.findByReparto", query = "SELECT p FROM PeliculasSeries p WHERE p.reparto = :reparto")
    , @NamedQuery(name = "PeliculasSeries.findByPelicula", query = "SELECT p FROM PeliculasSeries p WHERE p.pelicula = :pelicula")})
public class PeliculasSeries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "calificacion")
    private double calificacion;
    @Column(name = "anio")
    private String anio;
    @Column(name = "pais")
    private String pais;
    @Column(name = "director")
    private String director;
    @Column(name = "reparto")
    private String reparto;
    @Column(name = "pelicula")
    private Boolean pelicula;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Genero genero;
    private boolean selected;
    private File file;
    private UploadedFile files;
    
    
    

    public PeliculasSeries() {
    }
      

       
    public PeliculasSeries(Integer id, String name,String descripcion,
            double calificacion,String anio, String director, String reparto,
            boolean pelicula) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.anio = anio;
        this.director = director;
        this.reparto = reparto;
        this.pelicula = pelicula;
       
    }
    public PeliculasSeries(Integer id, String name,String descripcion,
             String director ) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public Boolean getPelicula() {
        return pelicula;
    }

    public void setPelicula(Boolean pelicula) {
        this.pelicula = pelicula;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculasSeries)) {
            return false;
        }
        PeliculasSeries other = (PeliculasSeries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeliculasSeries[ id=" + id + " "+ name + " "+ descripcion
                + " "+ calificacion + " "+ anio + " "+ director
                + " "+ reparto + " "+ genero + " "
                + "]";
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

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the files
     */
    public UploadedFile getFiles() {
        return files;
    }

    /**
     * @param files the files to set
     */
    public void setFiles(UploadedFile files) {
        this.files = files;
    }
    
}
