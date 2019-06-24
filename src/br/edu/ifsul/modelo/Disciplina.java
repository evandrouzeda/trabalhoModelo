
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Telmo Junior
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 100, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @NotNull(message = "A descrição deve ser informada")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Length(max = 50, message = "A descrição do arquivo não pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, length = 50)    
    private String descricao;

    @Min(message = "carga não pode ser negativo", value = 0)
    @NotNull(message = "carga deve ser informado")
    @Column(name = "carga", nullable = false, columnDefinition = "numeric(12,2)")
    private Double cargaHoraria;
    
    @NotNull(message = "conhecimentos deve ser informada")
    @NotBlank(message = "conhecimentos não pode ser em branco")
    @Length(max = 50, message = "conhecimentos do arquivo não pode ter mais que {max} caracteres")
    @Column(name = "conhecimentos", nullable = false, length = 50)    
    private String conhecimentosMinimos;

    @NotNull(message = "O curso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id", nullable = false, 
            foreignKey = @ForeignKey(name = "fk_displina_curso"))
    private Curso curso;//bidirecional
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "matriculas",
            joinColumns = 
            @JoinColumn(name = "disciplina", referencedColumnName = "nome", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "aluno", referencedColumnName = "nome", nullable = false)) 
    private Set<Aluno> matriculas;
    
    public Disciplina(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    public Set<Aluno> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<Aluno> matriculas) {
        this.matriculas = matriculas;
    }
}
