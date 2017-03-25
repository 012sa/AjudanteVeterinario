package br.edu.ifpb.resteasyapp.entidade;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Fazenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mensagem")
	private Integer id_mensagem;	
	
	@Column(name = "nm_fazenda")
	private String nome_fazenda;
	
	@Column(name = "nm_representante")
	private String nome_representate;
	
	@Column(name = "nm_email")
	private String email;
	
	@Column(name = "nm_mensagem")
	private String mensagem;
	

}
