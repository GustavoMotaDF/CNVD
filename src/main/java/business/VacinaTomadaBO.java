/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.VacinaTomada;
import entity.Usuario;
import entity.Vacina;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.QueryParameterException;

/**
 *
 * @author gustavo
 */
public class VacinaTomadaBO {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("estadoPU");

    public List<VacinaTomada> getVacinasTomadas() {

        List<VacinaTomada> qtdVacinas;

        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        qtdVacinas = en.createQuery("From VacinaTomada").getResultList();
        en.getTransaction().commit();

        en.clear();
        en.close();

        return qtdVacinas;

    }

    public void IncluirVacinaTomada(String dose, String idusuario, String idvacina) {
        EntityManager en = emf.createEntityManager();

        en.getTransaction().begin();

        VacinaTomada cartaovacina = new VacinaTomada();

        cartaovacina.setDose(dose);

        Usuario usuario = en.find(Usuario.class, Integer.valueOf(idusuario));
        cartaovacina.setUsuario(usuario);
        Vacina vacina = en.find(Vacina.class, Integer.valueOf(idvacina));
        cartaovacina.setVacinas(vacina);
        cartaovacina.setDataaplicacao((java.sql.Date) Date.from(Instant.now()));

        en.persist(cartaovacina);

        en.getTransaction().commit();
        en.clear();
        en.close();

    }

    public Boolean excluirVacinaTomada(String idvacinatomada) {
        try {
            EntityManager en = emf.createEntityManager();
            en.getTransaction().begin();

            VacinaTomada cartavacina = en.getReference(VacinaTomada.class, Integer.valueOf(idvacinatomada));
            en.remove(cartavacina);

            en.getTransaction().commit();
            en.clear();
            en.close();
            return true;
        } catch (Exception e) {

            System.err.println("Erro ao excluir Cartão de Vacina: Erro " + e.getMessage());
            return false;
        }
    }

    public VacinaTomada getVacinaTomada(String idvacinatomada) {

        VacinaTomada cartavacina;

        EntityManager en = emf.createEntityManager();

        en.getTransaction().begin();

        cartavacina = en.find(VacinaTomada.class, Integer.valueOf(idvacinatomada));

        en.getTransaction().commit();

        en.close();
        return cartavacina;

    }

    public void alterarVacinaTomada(String idvacinatomada, String dose, String idusuario, String idvacina) {
        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        VacinaTomada cartavacina = en.find(VacinaTomada.class, Integer.valueOf(idvacinatomada));
        cartavacina.setDose(dose);

        Usuario usuario = en.find(Usuario.class, Integer.valueOf(idusuario));
        cartavacina.setUsuario(usuario);
        Vacina vacina = en.find(Vacina.class, Integer.valueOf(idvacina));
        cartavacina.setVacinas(vacina);
        cartavacina.setDataaplicacao((java.sql.Date) Date.from(Instant.now()));

        en.persist(cartavacina);

        en.getTransaction().commit();
        en.clear();
        en.close();

    }

    //TESTE BUSCAR VACINAS TOMADAS POR ID DE USUARIO; RESULTADO TEM QUE SER LISTA
    public List<VacinaTomada> RelatorioVacina() {
        List<VacinaTomada> cartaovacinas;

        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        cartaovacinas = en.createQuery("select distinct id_vacina as Vacinas, count(id_vacina) as qtd from VacinaTomada id_vacina group by vacinas order by qtd desc ").getResultList();

        en.getTransaction().commit();

        en.clear();
        en.close();

        return cartaovacinas;
    }

    public List<VacinaTomada> RelatorioSangue(String cpf) {
        List<VacinaTomada> cartao;

        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        cartao = en.createQuery("select u.nome, u.tiposanguineo, u.dia, u.mes, u.ano, u.cpf, u.cidade, es.estado, u.cep, u.logradouro, u.numerocasa, va.vacina, v.dose, v.dataaplicacao,  gr.grupo from Usuario u join VacinaTomada v on u.idusuario = v.usuario join Vacina va on va.idvacina=v.vacinas join Estado es on es.idestado=u.estado join Grupo gr on gr.idgrupo=u.grupos where u.cpf=:cpf order by va.vacina").setParameter("cpf", cpf).getResultList();
        en.getTransaction().commit();
        en.clear();
        en.close();

        return cartao;

    }

    public List<VacinaTomada> CartaoVacinaPronto(String login, String senha) {
        List<VacinaTomada> cartao;

        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();
        cartao = en.createQuery("select u.nome, u.tiposanguineo, u.dia, u.mes, u.ano, u.cpf, u.cidade, es.estado, u.cep, u.logradouro, u.numerocasa, va.vacina, v.dose,v.dataaplicacao,  gr.grupo from Usuario u join VacinaTomada v on u.idusuario = v.usuario join Vacina va on va.idvacina=v.vacinas join Estado es on es.idestado=u.estado join Grupo gr on gr.idgrupo=u.grupos where u.login=:login and u.senha=:senha order by va.vacina").setParameter("login", login).setParameter("senha", senha).getResultList();
        en.getTransaction().commit();
        en.clear();
        en.close();
        try {
            if (cartao != null) {
                System.out.println("OK");

            }
        } catch (Exception e) {
            if (cartao == null) {
                System.err.println("Erro " + e.getCause().getMessage());
            }
            System.err.println("Erro " + e.getCause().getMessage());
        }

        return cartao;

    }

    public List<VacinaTomada> RelatorioEstadoss(String datainicios, String datafim, String estado) {
        List<VacinaTomada> estadoss = null;

        EntityManager en = emf.createEntityManager();
        en.getTransaction().begin();

        estadoss = en.createQuery("select distinct es.estado, va.vacina, count(va.vacina)\n"
                + "from Estado es \n"
                + "join Usuario us \n"
                + "on es.idestado=us.estado\n"
                + "join VacinaTomada vt \n"
                + "on vt.usuario = us.idusuario \n"
                + "join Vacina va\n"
                + "on va.idvacina=vt.vacinas\n"
                + "where vt.dataaplicacao BETWEEN DATE(:datainicios) and DATE(:datafim) and es.idestado =:estado group by va.vacina order by va.vacina")
                .setParameter("datainicios", datainicios)
                .setParameter("datafim", datafim)
                .setParameter("estado", Integer.valueOf(estado))
                .getResultList();

        en.getTransaction().commit();
        en.clear();
        en.close();

        return estadoss;

    }

}
