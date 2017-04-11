package br.edu.ifpb.resteasyapp.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tb_contrSanita")
@NamedQuery(name="Controle_Sanitario.getAll", query="from Controle_Sanitario")
public class Controle_Reprodutivo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_controleR")
	private int id;
	
	@Column(name = "tempoGestante")
	private Date tempoGestante;
	
	@Column(name = "tempoRestante")
	private Date tempoRestante;
	
	private Animal macho;
	
	
}