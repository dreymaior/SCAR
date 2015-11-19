package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import infra.SessionCreate;
import modelo.Usuario;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class UsuarioDao {
	
	private final Session session;
	
	public UsuarioDao(Session session){
		this.session = session;
	}
	
	public boolean existeUsuario(Usuario usuario) {
		Usuario encontrado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.uniqueResult();
		return encontrado != null;
	}
	
	public void create(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		session.save(usuario);
		tx.commit();
	}
	
	public Usuario load(String login) {
		return (Usuario) this.session.load(Usuario.class, login);
	}
	
	public void update(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		session.update(usuario);
		tx.commit();
	}
	
	public void delete(Usuario usuario) {		
		Transaction tx = session.beginTransaction();
		session.delete(usuario);
		tx.commit();
	}
	
	public List<Usuario> listaTudo() {
		return this.session.createCriteria(Usuario.class).list();
	}

}
