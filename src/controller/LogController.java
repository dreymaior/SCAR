package controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class LogController {

	@Path("/log")
	@Get
	public void teste(){
	}
}
