package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Controle_Sanitario;

public class Controle_SanitarioDAO extends GenericDao<Integer, Controle_Sanitario>{

	private static Controle_SanitarioDAO instance;
	
	public static Controle_SanitarioDAO getInstance() {		
		instance = new Controle_SanitarioDAO();		
		return instance;
	}
	
	@Override
	public List<Controle_Sanitario>getAll() throws SQLException {
		return super.getAll("Controle_Sanitario.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Controle_Sanitario.class;
	}

	@Override
	public Controle_Sanitario find(Controle_Sanitario entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}