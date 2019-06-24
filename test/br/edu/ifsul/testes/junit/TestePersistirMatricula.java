/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author evandrouzeda
 */
public class TestePersistirMatricula {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMatricula() {
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
        Disciplina obj = em.find(Disciplina.class, 3);
        obj.getMatriculas().add(em.find(Aluno.class, 1)); 
        //obj.getMatriculas().add(em.find(Aluno.class, 3)); 
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
}
