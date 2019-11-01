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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author gustavo
 */
@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_USUARIO")
    private Integer idusuario;
    @Column(name="NOME_USUARIO")
    private String nome;
    @Column(name="CPF")
    private String cpf;
    @Column(name="RG")
    private Integer rg;
    @Column(name="EMAIL")
    private String email;
    @Column(name="TELEFONE")
    private Long telefone;
    @Column(name="DATA_NASCIMENTO")
    private String datanascimento;
    @Column(name="LOCAL_NASCIMENTO")
    private String localnascimento;
    @Column(name="CEP")
    private Integer cep;
    @Column(name="LOGRADOURO")
    private String logradouro;
    @Column(name="NUMERO_CASA")
    private Integer numerocasa;
    @Column(name="BAIRRO")
    private String bairro;
    @Column(name="LOGIN")
    private String login;
    @Column(name="SENHA")
    private String senha;
    @Column(name="CIDADE")
    private String cidade;
    @Column(name="SEXO")
    private String sexo;
    @Column(name="TIPO_RESIDENCIA")
    private String tiporesidencia;
    @Column(name="TIPOSANGUINEO")
    private String tiposanguineo;
    @Column(name="ALERGIA")
    private String alergia;

    public Usuario(Integer idusuario, String nome, String cpf, Integer rg, String email, Long telefone, String datanascimento, String localnascimento, Integer cep, String logradouro, Integer numerocasa, String bairro, String login, String senha, String cidade, String sexo, String tiporesidencia, String tiposanguineo, String alergia, Estado estado, TipoUsuario tipousuario, List<Autenticacao> autenticacao, List<VacinaTomada> cartavacina) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.datanascimento = datanascimento;
        this.localnascimento = localnascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numerocasa = numerocasa;
        this.bairro = bairro;
        this.login = login;
        this.senha = senha;
        this.cidade = cidade;
        this.sexo = sexo;
        this.tiporesidencia = tiporesidencia;
        this.tiposanguineo = tiposanguineo;
        this.alergia = alergia;
        this.estado = estado;
        this.tipousuario = tipousuario;
        this.autenticacao = autenticacao;
        this.cartavacina = cartavacina;
    }
    

   
    
    
    
    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_USUARIO", referencedColumnName = "ID_TIPO_USUARIO")
    private TipoUsuario tipousuario;
    
    @OneToMany(mappedBy = "usuarios")
    private List<Autenticacao> autenticacao ;
    
    
    
    @OneToMany(mappedBy = "usuario")
    private List<VacinaTomada> cartavacina ;

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    
    
    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getLocalnascimento() {
        return localnascimento;
    }

    public void setLocalnascimento(String localnascimento) {
        this.localnascimento = localnascimento;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumerocasa() {
        return numerocasa;
    }

    public void setNumerocasa(Integer numerocasa) {
        this.numerocasa = numerocasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public List<Autenticacao> getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(List<Autenticacao> autenticacao) {
        this.autenticacao = autenticacao;
    }

    public List<VacinaTomada> getCartavacina() {
        return cartavacina;
    }

    public void setCartavacina(List<VacinaTomada> cartavacina) {
        this.cartavacina = cartavacina;
    }


    public String getTiporesidencia() {
        return tiporesidencia;
    }

    public void setTiporesidencia(String tiporesidencia) {
        this.tiporesidencia = tiporesidencia;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.idusuario);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.idusuario, other.idusuario);
    }

    /**
     *
     * @param idusuario
     * @param nome
     * @param cpf
     * @param rg
     * @param email
     * @param telefone
     * @param datanascimento
     * @param localnascimento
     * @param cep
     * @param logradouro
     * @param numerocasa
     * @param bairro
     * @param login
     * @param senha
     * @param cidade
     * @param sexo
     * @param tiporesidencia
     * @param estado
     * @param tipousuario
     * @param autenticacao
     * @param cartavacina
     */
    public Usuario(Integer idusuario, String nome, String cpf, Integer rg, String email, Long telefone, String datanascimento, String localnascimento, Integer cep, String logradouro, Integer numerocasa, String bairro, String login, String senha, String cidade, String sexo, String tiporesidencia, Estado estado, TipoUsuario tipousuario, List<Autenticacao> autenticacao,List<VacinaTomada> cartavacina) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.datanascimento = datanascimento;
        this.localnascimento = localnascimento;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numerocasa = numerocasa;
        this.bairro = bairro;
        this.login = login;
        this.senha = senha;
        this.cidade = cidade;
        this.sexo = sexo;
        this.tiporesidencia = tiporesidencia;
        this.estado = estado;
        this.tipousuario = tipousuario;
        this.autenticacao = autenticacao;
        
        this.cartavacina = cartavacina;
    }

    public Usuario() {
    }
    
}