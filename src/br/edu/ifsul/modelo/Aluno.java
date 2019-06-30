
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Telmo Junior
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aluno")
@NamedQuery(name="todosAlunoOrdemNome",query="from Aluno order by nome asc")

//definir uma Namequery para fazer a autenticacao do Aluno na aplicacao web
@NamedQuery(name="autenticacaoAluno", query = "from Aluno where nome = :paramNome and senha = :paramSenha")

@NamedQuery(name="getAluno", query = "from Aluno where nome = :paramNome")

public class Aluno implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)   
    private Integer id;
    
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não ser em branco")
    @Length(max = 10, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 10, nullable = false)   
    private String senha;
        
    @NotNull(message = "A data do nascimento não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false) 
    private Calendar dataNascimento;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false) 
    private String nome;
    
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não ser em branco")
    @Length(max = 50, message = "O email não pode ter mais de {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)    
    private String email;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes",
            joinColumns = 
            @JoinColumn(name = "nome", referencedColumnName = "nome", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false)) 
    private Set<Permissao> permissoes;
    
    
    
    public Aluno(){
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
