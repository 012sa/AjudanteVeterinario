package br.edu.ifpb.resteasyapp.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tb_animal")
@NamedQuery(name = "Animal.getAll", query = "from Animal")
public class Animal {

	public Animal() {

	}

	public Animal(String raca, String classificacao, String mae, String tipo, String sexo, String pais, int idade) {
		super();
		this.raca = raca;
		this.classificacao = classificacao;
		this.nome = nome;
		this.tipo = tipo;
		this.sexo = sexo;
		this.mae = mae;
		this.idade = idade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	private int id;

	@Column(name = "raca")
	private String raca;
	
	@Column(name = "classificacao")
	private String classificacao;

	@Column(name = "nome")
	private String nome;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "mae")
	private String mae;

	@Column(name = "idade")
	private int idade;

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	@XmlElement
	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	@XmlElement
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@XmlElement
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@XmlElement
	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	@XmlElement
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", raca=" + raca + ", nome=" + nome + ", tipo=" + tipo + ", sexo=" + sexo
				+ ", mae=" + mae + ", idade=" + idade + "]";
	}

}
