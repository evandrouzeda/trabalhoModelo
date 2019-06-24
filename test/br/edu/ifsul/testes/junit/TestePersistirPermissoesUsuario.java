package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jorge
 */
public class TestePersistirPermissoesUsuario {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPermissoesUsuario() {
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
    public void teste(){
        Aluno obj = em.find(Aluno.class, 1);
        obj.getPermissoes().add(em.find(Permissao.class, "ADMINISTRADOR"));
        //obj.getPermissoes().add(em.find(Permissao.class, "USUARIO"));      
        //obj.getPermissoes().add(em.find(Permissao.class, "CLIENTE"));              
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
