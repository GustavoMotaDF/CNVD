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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity


@SQLDelete(sql = "update tb_doenca set STATUSDO = 0 where id_doenca = ?")
@Table(name="tb_doenca")
public class Doenca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_DOENCA")
    private Integer iddoenca;
    @Column(name="DOENCA")
    private String doenca;
    @Column(name="STATUSDO")
    private Boolean ativo;
    
    @OneToMany(mappedBy = "doenca")
    private List<Vacina> vacina ;
    
    

    public Doenca() {
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Vacina> getVacina() {
        return vacina;
    }

    public void setVacina(List<Vacina> vacina) {
        this.vacina = vacina;
    }

    public Doenca(Integer iddoenca, String doenca, Boolean ativo, List<Vacina> vacina) {
        this.iddoenca = iddoenca;
        this.doenca = doenca;
        this.ativo = ativo;
        this.vacina = vacina;
    }

        
    
}
