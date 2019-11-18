/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;

/**
 *
 * @author gustavo
 */
@Entity
@SQLDelete(sql = "update tb_campanha set ativo = 0 where id_doenca = ?")
@Table(name="tb_campanhas")
public class Campanhas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CAMPANHA")
    private Long idcampanha;
    
    @Column(name="NOME_CAMPANHA")
    private String descricaocampanha;
    
    @Column(name="DATA_INICIO")
    private LocalDate datainicio;
    @Column(name="DATA_FIM")
    private LocalDate datafim;
    
    private Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    
    @ManyToOne
    @JoinColumn(name="ID_ESTADO")
    private Estado estadousuarios;
    
    @ManyToOne
    @JoinColumn(name="ID_VACINA")
    private Vacina vacinacampanha;

    public Campanhas(Long idcampanha, String descricaocampanha, LocalDate datainicio, LocalDate datafim, Estado estadousuarios, Vacina vacinacampanha) {
        this.idcampanha = idcampanha;
        this.descricaocampanha = descricaocampanha;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.estadousuarios = estadousuarios;
        this.vacinacampanha = vacinacampanha;
    }

    public Campanhas() {
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

    public LocalDate getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
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
        hash = 97 * hash + Objects.hashCode(this.idcampanha);
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
