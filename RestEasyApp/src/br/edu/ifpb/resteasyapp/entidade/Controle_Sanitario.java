package br.edu.ifpb.resteasyapp.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tb_contrSanita")
@NamedQuery(name="Controle_Sanitario.getAll", query="from Controle_Sanitario")
public class Controle_Sanitario {

	public Controle_Sanitario (){
		
	}
	
	public Controle_Sanitario(String descricao, String aplica�oes, String resultados, String vacina) {
		super();
		this.descricao = descricao;
		this.aplica�oes = aplica�oes;
		this.resultados = resultados;
		this.vacina = vacina;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_controle")
	private int id;
	
	@Column (name="descricao")
	private String descricao;
	
	@Column (name="aplicacoes")
	private String aplica�oes;
	
	@Column (name="resultados")
	private String resultados;
	
	@Column (name="vacinas")
	private String vacina;
	
	@ManyToOne
	private Animal animal;

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@XmlElement
	public String getAplica�oes() {
		return aplica�oes;
	}

	public void setAplica�oes(String aplica�oes) {
		this.aplica�oes = aplica�oes;
	}

	@XmlElement
	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	@XmlElement
	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	@Override
	public String toString() {
		return "Controle_Sanitario [id=" + id + ", descricao=" + descricao + ", aplica�oes=" + aplica�oes
				+ ", resultados=" + resultados + ", vacina=" + vacina + "]";
	}
	
	
}