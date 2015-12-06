package controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.SensorDao;
import modelo.Sensor;

@Resource
public class SensoresController {
	
	private final SensorDao dao;
	private final Result result;
	
	public SensoresController(SensorDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	@Post @Path("/sensores")
	public void adiciona(Sensor sensor) {
		dao.create(sensor);
		result.redirectTo(this).lista();
	}
	
	@Get @Path("/sensores/{id}")
	public Sensor edita(Long id) {
		return dao.load(id);
	}
	
	@Put @Path("/sensores/{sensor.id}")
	public void altera(Sensor sensor){
		dao.update(sensor);
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("/sensores/{id}")
	public void remove(Long id) {
		Sensor sensor = dao.load(id);
		dao.delete(sensor);
		result.redirectTo(this).lista();
	}
	
	@Get @Path("/sensores")
	public List<Sensor> lista() {
		return dao.listaTudo();
	}
	
	@Get @Path("/sensores/novo")
	public void formulario() {
	}
}
