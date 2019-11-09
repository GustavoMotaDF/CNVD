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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name="tb_vacinas")
public class Vacina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_VACINA")
    private Integer idvacina;
    @Column(name="VACINA")
    private String vacina;
    
    @ManyToOne
    @JoinColumn(name= "ID_DOENCA")
    private Doenca doenca;
    
    @OneToMany(mappedBy = "vacinas")
    private List<VacinaTomada> cartaovacina ;
    
    @OneToMany(mappedBy = "vacinacampanha")
    private List<Campanhas> campanha ;

    public List<Campanhas> getCampanha() {
        return campanha;
    }

    public void setCampanha(List<Campanhas> campanha) {
        this.campanha = campanha;
    }

    public Integer getIdvacina() {
        return idvacina;
    }

    public void setIdvacina(Integer idvacina) {
        this.idvacina = idvacina;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public List<VacinaTomada> getCartaovacina() {
        return cartaovacina;
    }

    public void setCartaovacina(List<VacinaTomada> cartaovacina) {
        this.cartaovacina = cartaovacina;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.idvacina);
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
        final Vacina other = (Vacina) obj;
        if (!Objects.equals(this.idvacina, other.idvacina)) {
            return false;
        }
        return true;
    }

    public Vacina(Integer idvacina, String vacina, Doenca doenca, List<VacinaTomada> cartaovacina, List<Campanhas> campanha) {
        this.idvacina = idvacina;
        this.vacina = vacina;
        this.doenca = doenca;
        this.cartaovacina = cartaovacina;
        this.campanha = campanha;
    }

    

    public Vacina() {
    }
    
    
}