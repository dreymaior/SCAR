package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import modelo.Sensores;

@Component
public class SensoresDao {
	
	private final Session session;
	
	public SensoresDao (Session session) {
		this.session = session;
	}
	
	public void create(Sensores sensores) {
		Transaction tx = session.beginTransaction();
		session.save(sensores);
		tx.commit();
	}
	
	public Sensores load(Long id){
		return (Sensores) this.session.load(Sensores.class, id);
	}
	
	public void update(Sensores sensores){
		Transaction tx = session.beginTransaction();
		this.session.update(sensores);
		tx.commit();
	}
	
	public void delete(Sensores sensores){
		Transaction tx = session.beginTransaction();
		this.session.delete(sensores);
		tx.commit();
	}
	
	public List<Sensores> listaTudo() {
		return this.session.createCriteria(Sensores.class).list();
	}

}
