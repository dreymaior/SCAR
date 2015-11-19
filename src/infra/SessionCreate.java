package infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class SessionCreate implements ComponentFactory<Session> {
	
	private final SessionFactory factory;
	private Session session;
	
	public SessionCreate(SessionFactory factory){
		this.factory = factory;
	}
	
	@PostConstruct
	public void open() {
		this.session = factory.openSession();
	}
	
	public Session getInstance() {
		return this.session;
	}
	
	@PreDestroy
	public void close() {
		this.session.close();
	}
	
}
