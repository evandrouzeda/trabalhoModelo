package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
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
public class TestePersistirProfessorAAluno {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirProfessorAAluno() {
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
        // carregar o usuário que eu quero usar para gerar a nova pessoa fisica
        Aluno usuario = em.find(Aluno.class, "evandrouzeda");
        Professor obj = new Professor(usuario);
        obj.setCep("99854-000");
        obj.setBairro("Centro");
        obj.setCidade(em.find(Especialidade.class, 1));        
        em.getTransaction().begin();
        // antes de persistir a pessoa fisica deve ser removido o usuário
        em.remove(usuario);
        em.merge(obj);
        em.getTransaction().commit();        
    }
    
}
