package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.resteasyapp.entidade.Peso;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;


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
	
	public List<Peso> getAllPesosByAnimal(int id_animal) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Peso> pesos = null;
		
		try{
		
			String hql = "from Peso p "
				+ "where p.animal.id = :id_animal";
			
			Query query = session.createQuery(hql);
			
			query.setParameter("id_animal", "%" + id_animal + "%");
			
			pesos = (List<Peso>) query.list();
			
		} catch(HibernateException hibernateException){
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
		
		} finally {
			session.close();
		}
		return pesos;
	}
	
}