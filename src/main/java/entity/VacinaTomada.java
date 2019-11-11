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
    @Column(name="DOSE")
    private String dose;    
    @Column(name="DIA")
    private String dia;
    
    @Column(name="MESS")
    private String mess;
    @Column(name="ANO")
    private String ano;
    
    
    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="ID_VACINA")
    private Vacina vacinas; 

    public VacinaTomada() {
    }

    public Integer getIdvacinatomada() {
        return idvacinatomada;
    }

    public void setIdvacinatomada(Integer idvacinatomada) {
        this.idvacinatomada = idvacinatomada;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    
    
    public String getMess() {
        return mess;
    }

    
    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.idvacinatomada);
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

    public VacinaTomada(Integer idvacinatomada, String dose, String dia, String mess, String ano, Usuario usuario, Vacina vacinas) {
        this.idvacinatomada = idvacinatomada;
        this.dose = dose;
        this.dia = dia;
        
        this.mess = mess;
        this.ano = ano;
        this.usuario = usuario;
        this.vacinas = vacinas;
    }

}