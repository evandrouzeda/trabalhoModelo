package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Professor.class)
public abstract class Professor_ extends br.edu.ifsul.modelo.Aluno_ {

	public static volatile SingularAttribute<Professor, Especialidade> cidade;
	public static volatile SingularAttribute<Professor, String> bairro;
	public static volatile SingularAttribute<Professor, String> cep;

	public static final String CIDADE = "cidade";
	public static final String BAIRRO = "bairro";
	public static final String CEP = "cep";

}

