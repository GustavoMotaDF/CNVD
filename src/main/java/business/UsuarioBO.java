/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Estado;
import entity.TipoUsuario;
import entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;

public class UsuarioBO {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("estadoPU");

    public void IncluirUsuario(String bairro, String cep, String cpf,
            String email, String localnascimento, String logradouro,
            String nome, String rg, String telefone, String login, String senha, String numerocasa,
            String idtipousuarios, String idestado, String cidade,
            String sexo, String datanascimento, String tiporesidencia, String tiposanguineo, String alergia
    ) {
        EntityManager en = emf.createEntityManager();

        en.getTransaction().begin();

        Usuario usuario = new Usuario();
        //usuario = new Usuario(nome, Long.parseLong(cpf), Integer.valueOf(rg), email, Long.parseLong(telefone), localnascimento, Integer.valueOf(cep), logradouro, Integer.valueOf(numerocasa), bairro, Integer.valueOf(sexo), Integer.valueOf(tiporesidencia), Integer.valueOf(cidade), Integer.valueOf(tipousuario));
        try {
            usuario.setBairro(bairro);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo BAIRRO " + e.getMessage());
        }
        try {
            usuario.setCep(Integer.valueOf(cep));
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo CEP " + e.getMessage());
        }
        try {
            usuario.setCpf(cpf);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo CPF " + e.getMessage());
        }
        try {
            usuario.setEmail(email);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo EMAIL " + e.getMessage());
        }
        try {
            usuario.setLocalnascimento(localnascimento);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo LOCAL NASCIMENTO " + e.getMessage());
        }
        try {
            usuario.setLogradouro(logradouro);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo LOGRADOURO " + e.getMessage());
        }
        try {
            usuario.setNome(nome);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo NOME " + e.getMessage());
        }
        try {
            usuario.setNumerocasa(Integer.valueOf(numerocasa));
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo NUMEROCASA " + e.getMessage());
        }
        try {
            usuario.setRg(Integer.valueOf(rg));
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo RG " + e.getMessage());
        }
        try {
            usuario.setTelefone(Long.valueOf(telefone));
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo TELEFONE " + e.getMessage());
        }
        try {
            usuario.setLogin(login);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo LOGIN " + e.getMessage());
        }
        try {
            usuario.setSenha(senha);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo SENHA " + e.getMessage());
        }

        try {
            TipoUsuario tipousuario = en.find(TipoUsuario.class, Integer.valueOf(idtipousuarios));
            usuario.setTipousuario(tipousuario);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo IDTIPOUSUARIO " + e.getMessage());
        }

        try {
            Estado estados = en.find(Estado.class, Integer.valueOf(idestado));
            usuario.setEstado(estados);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo IDESTADO " + e.getMessage());
        }

        try {
            usuario.setCidade(cidade);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo CIDADE " + e.getMessage());
        }
        try {
            usuario.setDatanascimento(datanascimento);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo DATANASCIMENTO " + e.getMessage());
        }
        try {
            usuario.setSexo(sexo);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo SEXO " + e.getMessage());
        }

        try {
            usuario.setTiporesidencia(tiporesidencia);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo TIPO DE RESIDENCIA " + e.getMessage());
        }
        try {
            usuario.setTiposanguineo(tiposanguineo);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo TIPO SANGUINEO " + e.getMessage());
        }
        try {
            usuario.setAlergia(alergia);
        } catch (Exception e) {
            System.err.println("erro, nao pode ser nulo ALERGIA " + e.getMessage());
        }

        en.persist(usuario);

        en.getTransaction().commit();
        en.clear();
        en.close();
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        usuarios = en.createQuery("from Usuario").getResultList();
        en.getTransaction().commit();
        en.clear();
        en.close();

        return usuarios;
    }

    public Boolean excluirUsuario(String idusuario) {
        try {
            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();

            Usuario usuario = en.getReference(Usuario.class, Integer.valueOf(idusuario));
            en.remove(usuario);

            en.getTransaction().commit();
            en.clear();
            en.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao excluir aluno de id " + idusuario + " :" + e.getMessage());
            return false;
        }
    }

    public Usuario getUsuario(String idusuario) {
        Usuario usuario;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        usuario = en.find(Usuario.class, Integer.valueOf(idusuario));
        en.getTransaction().commit();
        en.clear();
        en.close();
        return usuario;
    }

    public void alterarAluno(String idusuario, String bairro, String cep, String cpf,
            String email, String localnascimento, String logradouro,
            String nome, String rg, String telefone, String login, String senha, String numerocasa,
            String idtipousuarios, String idestado, String cidade,
            String sexo, String datanascimento, String tiporesidencia, String tiposanguineo, String alergia
    ) {
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        Usuario usuario = en.find(Usuario.class, Integer.valueOf(idusuario));

        usuario.setBairro(bairro);

        usuario.setCep(Integer.valueOf(cep));

        usuario.setCpf(cpf);

        usuario.setEmail(email);

        usuario.setLocalnascimento(localnascimento);

        usuario.setLogradouro(logradouro);

        usuario.setNome(nome);

        usuario.setNumerocasa(Integer.valueOf(numerocasa));

        usuario.setRg(Integer.valueOf(rg));

        usuario.setTelefone(Long.valueOf(telefone));

        usuario.setLogin(login);

        usuario.setSenha(senha);

        usuario.setCidade(cidade);

        usuario.setDatanascimento(datanascimento);

        usuario.setSexo(sexo);

        usuario.setTiporesidencia(tiporesidencia);

        TipoUsuario tipousuario = en.find(TipoUsuario.class, Integer.valueOf(idtipousuarios));
        usuario.setTipousuario(tipousuario);

        Estado estados = en.find(Estado.class, Integer.valueOf(idestado));
        usuario.setEstado(estados);

        usuario.setTiporesidencia(tiporesidencia);
        usuario.setTiposanguineo(tiposanguineo);
        usuario.setAlergia(alergia);

        en.merge(usuario);

        en.getTransaction().commit();
        en.clear();
        en.close();

    }

    public Usuario getUsuarioCPF(String cpf) {
        Usuario usuario;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        usuario = (Usuario) en.createQuery("SELECT u from Usuario u where u.cpf =:cpf").setParameter("cpf", cpf).getSingleResult();
        en.getTransaction().commit();
        en.clear();
        en.close();
        return usuario;
    }

    public Usuario getUsuarioNOME(String nome) {
        Usuario usuario;
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        usuario = (Usuario) en.createQuery("SELECT u from Usuario u where u.nome =:nome").setParameter("nome", nome).getSingleResult();
            
        en.getTransaction().commit();
        en.clear();
        en.close();
        return usuario;
        
    }
    public List<Usuario> RelatorioUsuarioEstado(){
        List<Usuario> userEstado;
       
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        
        userEstado = en.createQuery("select distinct id_estado as Estados, count(id_estado) as qtd from Usuario id_estado group by estado order by qtd desc ").getResultList();
               
        en.getTransaction().commit();
        
        en.clear();
        en.close();
        
        return userEstado;
}

}
