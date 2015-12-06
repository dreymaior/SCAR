package modelo;

import javax.persistence.*;

@Entity
public class Sensor {

	@Id @GeneratedValue
	private Long id;
	private String nome;
	private String tipo;
	
	// Verificar se os atributos estão corretos
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
