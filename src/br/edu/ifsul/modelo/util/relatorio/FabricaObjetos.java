
package br.edu.ifsul.modelo.util.relatorio;

import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.modelo.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Telmo Junior
 */
public class FabricaObjetos {
    
    public static List<Curso> carregaProdutos(){
            List<Curso> lista = new ArrayList<>();
            Instituicao m = new Instituicao();
            m.setNome("Dell");
            Curso p1 = new Curso();
            p1.setId(1);
            p1.setNome("Mouse Laser");
            lista.add(p1);
            Curso p2 = new Curso();
            p2.setId(2);
            p2.setNome("Teclado sem fio");
            lista.add(p2);  
            return lista;
    }
    
}
