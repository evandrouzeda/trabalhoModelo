
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Telmo Junior
 */
public class TestePersistirEspecialidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    @Before
    public void before(){
        
        emf = Persistence.createEntityManagerFactory("OSEletronicosModelPU");
        em = emf.createEntityManager();    
        
    }
    
    @After
    public void after(){
        em.close();
        emf.close();
    }
    
    @Test
    public void test(){
        
        Especialidade obj = new Especialidade();
        obj.setNome("Data Science");
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();  
    }
    
}
