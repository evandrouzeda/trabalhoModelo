
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
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
        
        Curso obj = em.find(Curso.class, 1);
        Disciplina d = new Disciplina();
        d.setNome("Estrutura de Dados II");
        d.setDescricao("a matéria q fico facil pakas");
        d.setCargaHoraria(Double.valueOf(42));
        d.setConhecimentosMinimos("ED2");
        obj.adicionarDisciplina(d);
        //obj.setNome("Ciencia da Computacao");
        //obj.setDescricao("Materia muito loka dos baratos loko mesmo");
        //obj.setInstituicao(em.find(Instituicao.class, 1));
        //obj.setSigla("CC");
        //obj.setInicioAtividades(Calendar.getInstance());
        //obj.setAtivo(Boolean.TRUE);
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();   
    }
    
}
