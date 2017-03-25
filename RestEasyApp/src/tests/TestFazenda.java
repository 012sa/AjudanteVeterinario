package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifpb.resteasyapp.entidade.Fazenda;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;
import org.hibernate.Session;

public class TestFazenda {
	public static void main(String args[]){
			
				Session session	= HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();

				Fazenda f = new Fazenda("fazendinha", "representante", "test@test.com", "mensagem");
				session.save(f);
				session.getTransaction().commit();
	}
}
