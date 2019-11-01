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
@Table(name="tb_vacina_tomada")
public class VacinaTomada implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_VACINA_TOMADA")
    private Integer idvacinatomada;
    @Column(name="DATA_VACINACAO")
    private String datavacinacao;
    @Column(name="DOSE")
    private String dose;    
    
    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="ID_VACINA")
    private Vacina vacinas; 

    public VacinaTomada() {
    }

    public VacinaTomada(Integer idvacinatomada, String datavacinacao, String dose, Usuario usuario, Vacina vacinas) {
        this.idvacinatomada = idvacinatomada;
        this.datavacinacao = datavacinacao;
        this.dose = dose;
        this.usuario = usuario;
        this.vacinas = vacinas;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idvacinatomada);
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
        final VacinaTomada other = (VacinaTomada) obj;
        if (!Objects.equals(this.idvacinatomada, other.idvacinatomada)) {
            return false;
        }
        return true;
    }

    public Integer getIdvacinatomada() {
        return idvacinatomada;
    }

    public void setIdvacinatomada(Integer idvacinatomada) {
        this.idvacinatomada = idvacinatomada;
    }

    public String getDatavacinacao() {
        return datavacinacao;
    }

    public void setDatavacinacao(String datavacinacao) {
        this.datavacinacao = datavacinacao;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vacina getVacinas() {
        return vacinas;
    }

    public void setVacinas(Vacina vacinas) {
        this.vacinas = vacinas;
    }

   

}