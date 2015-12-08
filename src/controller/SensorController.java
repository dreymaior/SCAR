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
public class SensorController {
	
	private final SensorDao dao;
	private final Result result;
	
	public SensorController(SensorDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	@Post @Path("/sensor")
	public void adiciona(Sensor sensor) {
		dao.create(sensor);
		result.redirectTo(this).lista();
	}
	
	@Get @Path("/sensor/{id}")
	public Sensor edita(Long id) {
		return dao.load(id);
	}
	
	@Put @Path("/sensor/{sensor.id}")
	public void altera(Sensor sensor){
		dao.update(sensor);
		result.redirectTo(this).lista();
	}
	
	@Delete @Path("/sensor/{id}")
	public void remove(Long id) {
		Sensor sensor = dao.load(id);
		dao.delete(sensor);
		result.redirectTo(this).lista();
	}
	
	@Get @Path("/sensor")
	public List<Sensor> lista() {
		return dao.listaTudo();
	}
	
	@Get @Path("/sensor/novo")
	public void formulario() {
	}
}
