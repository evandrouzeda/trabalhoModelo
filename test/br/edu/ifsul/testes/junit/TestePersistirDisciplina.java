package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Curso;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class TestePersistirDisciplina {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirDisciplina() {
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
    public void teste() throws IOException {
        Curso p = em.find(Curso.class, 1);
        Disciplina d = new Disciplina();
        d.setNome("Redes de Computadores II");
        d.setDescricao("a materia q o evandro sabe bem kkkkk");
        d.setCargaHoraria(Double.valueOf(42));
        d.setConhecimentosMinimos("RC1");
        d.setCurso(p);
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
    }

}
