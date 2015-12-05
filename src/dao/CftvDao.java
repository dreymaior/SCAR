package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import infra.SessionCreate;
import modelo.Cftv;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class CftvDao {

	private final Session session;
	
	public CftvDao(Session session){
		this.session = session;
	}
	
	public List<Cftv> listaTudo() {
		return this.session.createCriteria(Cftv.class).list();
	}
}