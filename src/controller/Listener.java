package controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class Listener {
	
	@Path("")
	@Get
	public void index(){
	}
	
}
