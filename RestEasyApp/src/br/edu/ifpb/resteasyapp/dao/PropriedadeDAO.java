	package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.resteasyapp.entidade.Propriedade;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

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
	
	public Propriedade findPropriedadeByNome(String nome) throws SQLException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Propriedade propriedade = null;
		
		try{
		
			String hql = "from Propriedade p "
				+ "where p.nome like :nome";
			
			Query query = session.createQuery(hql);
			
			query.setParameter("nome", "%" + nome + "%");
			
			propriedade = (Propriedade) query.uniqueResult();
			
		} catch(HibernateException hibernateException){
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
		
		} finally {
			session.close();
		}
		return propriedade;
	}
	
}