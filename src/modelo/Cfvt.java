package modelo;

import javax.persistence.*;

@Entity
public class Cfvt{
	
	private String nome;
	@Id

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
