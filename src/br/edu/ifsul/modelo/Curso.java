/*
 * Composição: aplica-se a atributos do tipo complexo ou composto, não se aplica a tipos primitivos. No relacionamento do tipo composição, existe uma dependencia, ou seja, arquivo não existe sem o produto.
(Disciplina compoem Curso)       

No entanto, no relacionamento do tipo agregação, o agregado vive sem o agregador.

O losango é possicionado no lado da classe agregadora. Sempre do lado do losango vai ter a cardinalidade 1.

Geralmente na agregação por composição os objetos agregados são instanciados dentro da classe agregadora,já que
são, totalmente dependentes.

fonte: https://www.ateomomento.com.br/uml-classes-agregacao/

alto acoplamento: inclusão de atribuições que não sao inerentes
baixa coesao: mistura de conceitos.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Telmo Junior
 */

@Entity
@Table(name = "curso")
public class Curso implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O sigla não pode ser nulo")
    @NotBlank(message = "O sigla não pode ser em branco")
    @Length(max = 5, message = "O sigla não pode ter mais que {max} caracteres")
    @Column(name = "sigla", length = 5, nullable = false)
    private String sigla;
    
    @Column(name = "descricao", length = 200, columnDefinition = "text")
    private String descricao;
    
    @NotNull(message = "A data do inicio não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio_atividade", nullable = false) 
    private Calendar inicioAtividades;
    
    @Type(type = "true_false")
    @Column(name = "ativo")
    private Boolean ativo;
    
    @NotNull(message = "A instituicao deve ser informada")
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_curso_instituicao"))
    private Instituicao instituicao;//associação: produto referencia marca (nesse caso, como tem seta direcional, é  unidirecional)
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL,
        orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Disciplina> disciplina;//composição, ou seja, arquivo nao vive sem o produto. Disciplina por sua vez, referencia Curso. É bidirecional pois, não tem sentido
    
    
    public void adicionarDisciplina(Disciplina obj) {
        obj.setCurso(this);
        this.disciplina.add(obj);
    }

    public void removerArquivo(int index) {
        this.disciplina.remove(index);
    }
    
    public Curso(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instituicao getInstitucao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
