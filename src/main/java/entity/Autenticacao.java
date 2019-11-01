/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name="tb_autenticacao")
public class Autenticacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_AUTENTICACAO")
    private Long idautenticacao;
    @Column(name="DATALOGIN")
    private LocalDateTime datalogin;
    
    
    
    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuarios;


    public Long getIdautenticacao() {
        return idautenticacao;
    }

    public void setIdautenticacao(Long idautenticacao) {
        this.idautenticacao = idautenticacao;
    }

    public LocalDateTime getDatalogin() {
        return datalogin;
    }

    public void setDatalogin(LocalDateTime datalogin) {
        this.datalogin = datalogin;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idautenticacao);
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
        final Autenticacao other = (Autenticacao) obj;
        if (!Objects.equals(this.idautenticacao, other.idautenticacao)) {
            return false;
        }
        return true;
    }

    public Autenticacao(LocalDateTime datalogin, Usuario usuarios) {
        this.datalogin = datalogin;
        this.usuarios = usuarios;
    }

    public Autenticacao(Long idautenticacao) {
        this.idautenticacao = idautenticacao;
    }

    public Autenticacao() {
    }

    
    
}
