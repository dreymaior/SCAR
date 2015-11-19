package controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class SensoresController {

	@Path("/sensores")
	@Get
	public void teste(){
	}
}
