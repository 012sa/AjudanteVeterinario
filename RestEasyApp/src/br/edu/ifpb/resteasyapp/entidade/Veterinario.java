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
@Table(name = "tb_Veterinario")
@NamedQuery(name="Veterinario.getAll", query="from Veterinario")
public class Veterinario {
	
	public Veterinario (){
		
	}
	
	public Veterinario(String nome, String senha, String email) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_Veterinario")
	private int id;
	
	@Column (name="nome")
	private String nome;
	
	@Column (name="senha")
	private String senha;
	
	@Column (name="email", unique=true)
	private String email;

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Veterinario [nome=" + nome + ", senha=" + senha + ", email=" + email + "]";
	}
	
	
	
}
