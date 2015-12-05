package modelo;

import javax.persistence.*;

@Entity
public class Cftv{
	
	private String nome;
	@Id
	@GeneratedValue
	private int id;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
