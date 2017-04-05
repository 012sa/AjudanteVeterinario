package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Peso;


public class PesoDAO extends GenericDao<Integer, Peso>{

	private static PesoDAO instance;
	
	public static PesoDAO getInstance() {		
		instance = new PesoDAO();		
		return instance;
	}
	
	@Override
	public List<Peso>getAll() throws SQLException {
		return super.getAll("Peso.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Peso.class;
	}

	@Override
	public Peso find(Peso entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}