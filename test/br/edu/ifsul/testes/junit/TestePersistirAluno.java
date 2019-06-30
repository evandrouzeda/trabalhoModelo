package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Aluno;
import java.util.Calendar;
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
public class TestePersistirAluno {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirAluno() {
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
        Aluno obj = new Aluno();
        obj.setEmail("teste@gmail.com");
        obj.setNome("teste");
        obj.setSenha("123456");
        obj.setDataNascimento(Calendar.getInstance());        
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
