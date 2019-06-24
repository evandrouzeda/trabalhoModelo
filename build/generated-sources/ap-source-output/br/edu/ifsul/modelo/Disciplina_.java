package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Disciplina.class)
public abstract class Disciplina_ {

	public static volatile SingularAttribute<Disciplina, String> conhecimentosMinimos;
	public static volatile SingularAttribute<Disciplina, Curso> curso;
	public static volatile SingularAttribute<Disciplina, String> nome;
	public static volatile SingularAttribute<Disciplina, Integer> id;
	public static volatile SetAttribute<Disciplina, Aluno> matriculas;
	public static volatile SingularAttribute<Disciplina, Double> cargaHoraria;
	public static volatile SingularAttribute<Disciplina, String> descricao;

	public static final String CONHECIMENTOS_MINIMOS = "conhecimentosMinimos";
	public static final String CURSO = "curso";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String MATRICULAS = "matriculas";
	public static final String CARGA_HORARIA = "cargaHoraria";
	public static final String DESCRICAO = "descricao";

}

