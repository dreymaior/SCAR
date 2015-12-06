package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import modelo.Sensor;

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
	
}
