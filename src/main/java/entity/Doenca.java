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
@Table(name="tb_doenca")
public class Doenca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_DOENCA")
    private Integer iddoenca;
    @Column(name="DOENCA")
    private String doenca;
    
    @OneToMany(mappedBy = "doenca")
    private List<Vacina> vacina ;

    public Doenca() {
    }

    public Doenca(String doenca, List<Vacina> vacina) {
        this.doenca = doenca;
        this.vacina = vacina;
    }
    

    public Integer getIddoenca() {
        return iddoenca;
    }

    public void setIddoenca(Integer iddoenca) {
        this.iddoenca = iddoenca;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public List<Vacina> getVacina() {
        return vacina;
    }

    public void setVacina(List<Vacina> vacina) {
        this.vacina = vacina;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 31;
        hash = 31* hash + Objects.hashCode(this.iddoenca);
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
        final Doenca other = (Doenca) obj;
        if (!Objects.equals(this.iddoenca, other.iddoenca)) {
            return false;
        }
        return true;
    }
    
    
    
}
