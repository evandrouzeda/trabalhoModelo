package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ {

	public static volatile SingularAttribute<Aluno, String> senha;
	public static volatile SetAttribute<Aluno, Permissao> permissoes;
	public static volatile SingularAttribute<Aluno, String> nome;
	public static volatile SingularAttribute<Aluno, Integer> id;
	public static volatile SingularAttribute<Aluno, Calendar> dataNascimento;
	public static volatile SingularAttribute<Aluno, String> email;

	public static final String SENHA = "senha";
	public static final String PERMISSOES = "permissoes";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String DATA_NASCIMENTO = "dataNascimento";
	public static final String EMAIL = "email";

}

