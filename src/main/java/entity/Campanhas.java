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
    
    @Column(name="DIA_INICIO")
    private String diainicio;
    @Column(name="DIA_FIM")
    private String diafim;
    @Column(name="MES_INICIO")
    private String mesinicio;
    @Column(name="MES_FIM")
    private String mesfim;
    @Column(name="ANO_INICIO")
    private String anoinicio;
    @Column(name="ANO_FIM")
    private String anofim;
    
    @ManyToOne
    @JoinColumn(name="ID_ESTADO")
    private Estado estadousuarios;
    
    @ManyToOne
    @JoinColumn(name="ID_VACINA")
    private Vacina vacinacampanha;

    public Campanhas() {
    }

    public Campanhas(Long idcampanha, String descricaocampanha, String diainicio, String diafim, String mesinicio, String mesfim, String anoinicio, String anofim, Estado estadousuarios, Vacina vacinacampanha) {
        this.idcampanha = idcampanha;
        this.descricaocampanha = descricaocampanha;
        this.diainicio = diainicio;
        this.diafim = diafim;
        this.mesinicio = mesinicio;
        this.mesfim = mesfim;
        this.anoinicio = anoinicio;
        this.anofim = anofim;
        this.estadousuarios = estadousuarios;
        this.vacinacampanha = vacinacampanha;
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

    public String getDiainicio() {
        return diainicio;
    }

    public void setDiainicio(String diainicio) {
        this.diainicio = diainicio;
    }

    public String getDiafim() {
        return diafim;
    }

    public void setDiafim(String diafim) {
        this.diafim = diafim;
    }

    public String getMesinicio() {
        return mesinicio;
    }

    public void setMesinicio(String mesinicio) {
        this.mesinicio = mesinicio;
    }

    public String getMesfim() {
        return mesfim;
    }

    public void setMesfim(String mesfim) {
        this.mesfim = mesfim;
    }

    public String getAnoinicio() {
        return anoinicio;
    }

    public void setAnoinicio(String anoinicio) {
        this.anoinicio = anoinicio;
    }

    public String getAnofim() {
        return anofim;
    }

    public void setAnofim(String anofim) {
        this.anofim = anofim;
    }

    public Estado getEstadousuarios() {
        return estadousuarios;
    }

    public void setEstadousuarios(Estado estadousuarios) {
        this.estadousuarios = estadousuarios;
    }

    public Vacina getVacinacampanha() {
        return vacinacampanha;
    }

    public void setVacinacampanha(Vacina vacinacampanha) {
        this.vacinacampanha = vacinacampanha;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idcampanha);
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

    
}
