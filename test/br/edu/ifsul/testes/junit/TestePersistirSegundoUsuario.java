package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class TestePersistirSegundoUsuario {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirSegundoUsuario() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("OSEletronicosModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        Aluno obj = new Aluno();
        obj.setEmail("carlos@gmail.com");
        obj.setNome("carlos");
        obj.setSenha("123456");
        obj.getPermissoes().add(em.find(Permissao.class, "ADMINISTRADOR"));
        obj.getPermissoes().add(em.find(Permissao.class, "USUARIO"));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

}
