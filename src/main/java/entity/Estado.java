/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name="tb_estado")
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ESTADO")
    private Integer idestado;
    
    @Column(name="ESTADO")
    private String estado;
    
    @Column(name="UF")
    private String uf;    
    
    @OneToMany(mappedBy = "estado")
    private List<Usuario> usuarios;
    
    @OneToMany(mappedBy = "estadousuarios")
    private List<Campanhas> campanha ;

    public List<Campanhas> getCampanha() {
        return campanha;
    }

    public void setCampanha(List<Campanhas> campanha) {
        this.campanha = campanha;
    }

    
    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idestado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.idestado, other.idestado)) {
            return false;
        }
        return true;
    }

    public Estado(Integer idestado, String estado, String uf, List<Usuario> usuarios) {
        this.idestado = idestado;
        this.estado = estado;
        this.uf = uf;
        this.usuarios = usuarios;
    }

    public Estado() {
    }

    

}

