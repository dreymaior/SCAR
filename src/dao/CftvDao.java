package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import modelo.Cftv;


@Component
public class CftvDao {

	private final Session session;
	
	public CftvDao (Session session) {
		this.session = session;
	}
	public List<Cftv> listaTudo() {
		return this.session.createCriteria(Cftv.class).list();
	}
	public void create(Cftv cftv) {
		Transaction tx = session.beginTransaction();
		session.save(cftv);
		tx.commit();
	}
	public Cftv load(Long id){
		return (Cftv) this.session.load(Cftv.class, id);
	}
}
