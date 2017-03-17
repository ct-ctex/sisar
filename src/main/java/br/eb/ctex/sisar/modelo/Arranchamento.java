/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eb.ctex.sisar.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ralfh
 */
@Entity
public class Arranchamento implements Serializable {

    private static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date dataArr;
    private String posto;
    private String nome;
    private Boolean cafe;
    private Boolean almoco;
    private Boolean janta;
    
    public Arranchamento() {        
    }
    
    public Arranchamento(Usuario usuario) {
        this.posto = usuario.getPosto();
        this.nome = usuario.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the dataArr
     */
    public Date getDataArr() {
        return dataArr;
    }

    /**
     * @param dataArr the dataArr to set
     */
    public void setDataArr(Date dataArr) {
        this.dataArr = dataArr;
    }

    /**
     * @return the posto
     */
    public String getPosto() {
        return posto;
    }

    /**
     * @param posto the posto to set
     */
    public void setPosto(String posto) {
        this.posto = posto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cafe
     */
    public Boolean getCafe() {
        return cafe;
    }

    /**
     * @param cafe the cafe to set
     */
    public void setCafe(Boolean cafe) {
        this.cafe = cafe;
    }

    /**
     * @return the almoco
     */
    public Boolean getAlmoco() {
        return almoco;
    }

    /**
     * @param almoco the almoco to set
     */
    public void setAlmoco(Boolean almoco) {
        this.almoco = almoco;
    }

    /**
     * @return the janta
     */
    public Boolean getJanta() {
        return janta;
    }

    /**
     * @param janta the janta to set
     */
    public void setJanta(Boolean janta) {
        this.janta = janta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arranchamento)) {
            return false;
        }
        Arranchamento other = (Arranchamento) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.eb.ctex.sisar.modelo.Arranchamento[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    
}
