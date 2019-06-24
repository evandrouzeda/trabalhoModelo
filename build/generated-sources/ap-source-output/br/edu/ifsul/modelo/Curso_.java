package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Curso.class)
public abstract class Curso_ {

	public static volatile SingularAttribute<Curso, Calendar> inicioAtividades;
	public static volatile SingularAttribute<Curso, Boolean> ativo;
	public static volatile SingularAttribute<Curso, String> sigla;
	public static volatile ListAttribute<Curso, Disciplina> disciplina;
	public static volatile SingularAttribute<Curso, Instituicao> instituicao;
	public static volatile SingularAttribute<Curso, String> nome;
	public static volatile SingularAttribute<Curso, Integer> id;
	public static volatile SingularAttribute<Curso, String> descricao;

	public static final String INICIO_ATIVIDADES = "inicioAtividades";
	public static final String ATIVO = "ativo";
	public static final String SIGLA = "sigla";
	public static final String DISCIPLINA = "disciplina";
	public static final String INSTITUICAO = "instituicao";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String DESCRICAO = "descricao";

}

