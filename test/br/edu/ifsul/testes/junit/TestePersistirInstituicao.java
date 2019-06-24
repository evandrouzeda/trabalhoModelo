package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;
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
public class TestePersistirInstituicao {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirInstituicao() {
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
        Instituicao obj = new Instituicao();
        obj.setNome("IFSUL");  
        obj.setDataFundacao(Calendar.getInstance()); 
        Instituicao obj2 = new Instituicao();
        obj2.setNome("UPF");
        obj2.setDataFundacao(Calendar.getInstance());
        em.getTransaction().begin();
        em.persist(obj);
        em.persist(obj2);
        em.getTransaction().commit();        
    }
    
}
