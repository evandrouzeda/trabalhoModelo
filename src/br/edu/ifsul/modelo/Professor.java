
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Telmo Junior
 */

@Entity
@Table
@DiscriminatorValue(value = "PF")
@NamedQueries({
    @NamedQuery(name = "Professor.todosOrderNome", query = "from Professor order by nome")
})
public class Professor extends Aluno implements Serializable {
    
    @NotNull(message = "O cep não pode ser nulo")
    @NotBlank(message = "O cep não ser em branco")
    @Length(max = 9, message = "O cep não pode ter mais de {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    
    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não ser em branco")
    @Length(max = 40, message = "O bairro não pode ter mais de {max} caracteres")
    @Column(name = "bairro", length = 40, nullable = false)
    private String bairro;
    
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_cidade_id"))
    private Especialidade cidade;//cidade associação
    
    
    public Professor(){
        super();
    }
    
    /**
     * Método para se criar uma pessoa fisica com base em um usuário que já
     * existe
     *
     * @param usuario registro que já existe no banco Antes de salvar a nova
     * pessoa física o usuario que já existia no banco deve ser removido
     */
    public Professor(Aluno usuario) {
        super.setId(usuario.getId());
        super.setSenha(usuario.getSenha());
        super.setDataNascimento(usuario.getDataNascimento());
        super.setNome(usuario.getNome());
        super.setEmail(usuario.getEmail());
        super.setPermissoes(usuario.getPermissoes());

    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Especialidade getCidade() {
        return cidade;
    }

    public void setCidade(Especialidade cidade) {
        this.cidade = cidade;
    }
    
}
