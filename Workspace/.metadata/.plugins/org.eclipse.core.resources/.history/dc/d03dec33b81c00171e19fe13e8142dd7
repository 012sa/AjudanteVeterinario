package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Propriedade;

public class PropriedadeDAO extends GenericDao<Integer, Propriedade>{

	private static PropriedadeDAO instance;
	
	public static PropriedadeDAO getInstance() {		
		instance = new PropriedadeDAO();		
		return instance;
	}
	
	@Override
	public List<Propriedade> getAll() throws SQLException {
		return super.getAll("Propriedade.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Propriedade.class;
	}

	@Override
	public Propriedade find(Propriedade entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}