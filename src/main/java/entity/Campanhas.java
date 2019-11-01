/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name="tb_campanhas")
public class Campanhas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CAMPANHA")
    private Long idcampanha;
    
    @Column(name="NOME_CAMPANHA")
    private String descricaocampanha;
    
    @Column(name="DATA_CAMPANHA")
    private String datacampanha;
    
    @Column(name="DATA_CAMPANHA_FIM")
    private String datacampanhafim;
    
    @ManyToOne
    @JoinColumn(name="ID_ESTADO")
    private Estado estadousuarios;

    public Campanhas() {
    }

    public String getDatacampanhafim() {
        return datacampanhafim;
    }

    public void setDatacampanhafim(String datacampanhafim) {
        this.datacampanhafim = datacampanhafim;
    }
    
    

    public Long getIdcampanha() {
        return idcampanha;
    }

    public void setIdcampanha(Long idcampanha) {
        this.idcampanha = idcampanha;
    }

    public String getDescricaocampanha() {
        return descricaocampanha;
    }

    public void setDescricaocampanha(String descricaocampanha) {
        this.descricaocampanha = descricaocampanha;
    }

    public String getDatacampanha() {
        return datacampanha;
    }

    public void setDatacampanha(String datacampanha) {
        this.datacampanha = datacampanha;
    }

    public Estado getEstadousuarios() {
        return estadousuarios;
    }

    public void setEstadousuarios(Estado estadousuarios) {
        this.estadousuarios = estadousuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idcampanha);
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
        final Campanhas other = (Campanhas) obj;
        if (!Objects.equals(this.idcampanha, other.idcampanha)) {
            return false;
        }
        return true;
    }

    public Campanhas(Long idcampanha, String descricaocampanha, String datacampanha, String datacampanhafim, Estado estadousuarios) {
        this.idcampanha = idcampanha;
        this.descricaocampanha = descricaocampanha;
        this.datacampanha = datacampanha;
        this.datacampanhafim = datacampanhafim;
        this.estadousuarios = estadousuarios;
    }

    
      
    
}
