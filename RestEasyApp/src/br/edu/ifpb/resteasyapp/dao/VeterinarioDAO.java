package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Veterinario;



public class VeterinarioDAO extends GenericDao<Integer, Veterinario>{

	private static VeterinarioDAO instance;
	
	public static VeterinarioDAO getInstance() {		
		instance = new VeterinarioDAO();		
		return instance;
	}
	
	@Override
	public List<Veterinario> getAll() throws SQLException {
		return super.getAll("Veterinario.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Veterinario.class;
	}

	@Override
	public Veterinario find(Veterinario entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}