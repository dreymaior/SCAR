package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import modelo.Sensor;
import modelo.Usuario;

@Component
public class SensorDao {

	private final Session session;
	
	public SensorDao (Session session) {
		this.session = session;
	}
	
	public void create(Sensor sensor) {
		Transaction tx = session.beginTransaction();
		session.save(sensor);
		tx.commit();
	}
	
	public Sensor load(Long id){
		return (Sensor) this.session.load(Sensor.class, id);
	}
	
	public void update(Sensor sensor){
		Transaction tx = session.beginTransaction();
		this.session.update(sensor);
		tx.commit();
	}
	
	public void delete(Sensor sensor){
		Transaction tx = session.beginTransaction();
		this.session.delete(sensor);
		tx.commit();
	}
	
	public List<Sensor> listaTudo() {
		return this.session.createCriteria(Sensor.class).list();
	}

	public List<Sensor> busca1(String nome) {
		
		return session.createCriteria(Sensor.class).add(Restrictions.ilike("nome",nome, MatchMode.ANYWHERE)).list();
	}
	
}
