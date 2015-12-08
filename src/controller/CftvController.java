package controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.CftvDao;
import modelo.Cftv;


@Resource
public class CftvController {
	private final CftvDao dao;
	private final Result result;
	
	public CftvController(CftvDao dao, Result result) {
		this.dao = dao;
		this.result = result;
	}
	
	
	@Path("/cftv")
	@Get
	public List<Cftv> lista() {
		return dao.listaTudo();
	}
}
