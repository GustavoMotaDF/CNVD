/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo_usuario")
public class TipoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_TIPO_USUARIO")
    private Integer idtipousuario;
    @Column(name="TIPO_USUARIO")
    private String tipousuario;
    
    @OneToMany(mappedBy = "tipousuario", cascade=CascadeType.ALL)
    private List<Usuario> usuario;

    public TipoUsuario() {
    }

    public TipoUsuario(String tipousuario, List<Usuario> usuario) {
        this.tipousuario = tipousuario;
        this.usuario = usuario;
    }
    
    
    
    

    public Integer getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idtipousuario);
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
        final TipoUsuario other = (TipoUsuario) obj;
        if (!Objects.equals(this.idtipousuario, other.idtipousuario)) {
            return false;
        }
        return true;
    }
    
    
    
}
