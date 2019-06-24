
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Curso;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Telmo
 */
public class TestePersistirCurso {
    
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
        
        Curso obj = new Curso();
        obj.setNome("Ciencia da Computacao");
        obj.setDescricao("Materia muito loka dos baratos loko mesmo");
        obj.setInstituicao(em.find(Instituicao.class, 1));
        obj.setSigla("CC");
        obj.setInicioAtividades(Calendar.getInstance());
        obj.setAtivo(Boolean.TRUE);
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();   
    }
    
}
