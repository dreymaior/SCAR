package controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;
import dao.UsuarioDao;
import modelo.Usuario;

@Resource
public class UsuariosController {
	
	private UsuarioDao dao;
	private Result result;
	private Validator validator;
	
	
	public UsuariosController(UsuarioDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Path("/usuarios")
	@Post
	public void adiciona(Usuario usuario){
		
		if (usuario.getNome() == null || usuario.getNome().length() < 3){
			validator.add(new ValidationMessage(
					"Nome é obrigatório e precisa ter mais de 3 letras",
					"usuario.nome"));
		}
		
		if (usuario.getSobrenome() == null || usuario.getSobrenome().length() < 3){
			validator.add(new ValidationMessage(
					"Sobrenome é obrigatório e precisa ter mais de 3 letras",
					"usuario.sobrenome"));
		}
		
		if (dao.existeUsuario(usuario)) {
			validator.add(new ValidationMessage(
					"Login já existe",
					"usuario.login"));
		}
		
		if (usuario.getCpfCnpj() == null || usuario.getCpfCnpj().length() != 11){
			validator.add(new ValidationMessage(
					"CPF/CNPJ é obrigatório e precisa ser válido",
					"usuario.cpfCnpj"));
		}
		
		if (usuario.getTelefone() == null || usuario.getTelefone().length() < 10){
			validator.add(new ValidationMessage(
					"Telefone é obrigatório e ter no mínimo 8 caracteres 4499999999",
					"usuario.telefone"));
		}
		
		if (usuario.getEndereco() == null || usuario.getEndereco().length() < 10){
			validator.add(new ValidationMessage(
					"Endereço é obrigatório e ter pelo menos 10 caracteres",
					"usuario.endereco"));
		}
		
		validator.onErrorUsePageOf(UsuariosController.class).formulario();
		
		dao.create(usuario);
		result.redirectTo(this).lista();
	}
	
	@Path("/usuarios/{login}")
	@Get
	public Usuario edita(String login) {
		return dao.load(login);
	}
	
	@Path("/usuarios/{usuario.login}")
	@Put
	public void altera(Usuario usuario) {
		dao.update(usuario);
		result.redirectTo(this).lista();
	}
	
	@Path("/usuarios/{login}")
	@Delete
	public void remove(String login){
		Usuario usuario = dao.load(login);
		dao.delete(usuario);
		result.redirectTo(UsuariosController.class).lista();
	}

	@Path("/usuarios")
	@Get
	public List<Usuario> lista() {
		return dao.listaTudo();
	}
	
	@Path("/usuarios/novo/usuario")
	@Get
	public void formulario(){
	}
	
}
