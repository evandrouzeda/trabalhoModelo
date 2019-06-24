package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
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
public class TestePersistirProfessor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirProfessor() {
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
        Professor obj = new Professor();
        obj.setEmail("joao@gmail.com");
        obj.setNome("joao");
        obj.setSenha("123456");
        obj.setCep("99854-000");
        obj.setBairro("Centro");
        obj.setDataNascimento(Calendar.getInstance());
        obj.setCidade(em.find(Especialidade.class, 1));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
