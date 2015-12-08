package controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
<<<<<<< HEAD
import dao.SensorDao;
import modelo.Sensor;
import modelo.Usuario;
=======
import dao.SensoresDao;
import modelo.Sensores;
>>>>>>> master

@Resource
public class SensoresController {

	private final SensoresDao dao;
	private final Result result;
	
	public SensoresController(SensoresDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	@Post @Path("/admin/sensores")
	public void adiciona(Sensores sensores) {
		dao.create(sensores);
		result.redirectTo(this).lista();
	}
	
	@Get @Path("/admin/sensores/{id}")
	public Sensores edita(Long id) {
		return dao.load(id);
	}
	
	@Delete @Path("/admin/sensores/{id}")
	public void remove(Long id){
		Sensores sensores = dao.load(id);
		dao.delete(sensores);
		result.redirectTo(this).lista();
	}
	
	@Get @Path("/admin/sensores")
	public List<Sensores> lista(){
		return dao.listaTudo();
	}
	
	@Get @Path("/admin/sensores/novo")
	public void formulario(){
	}
	
	@Path("/busca1")
	@Get
	public List<Sensor> busca1(String nome){
		result.include("nome", nome);
		result.include("tipo", nome);
		return dao.busca1(nome);
	}
}
