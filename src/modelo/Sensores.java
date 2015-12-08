package modelo;

import javax.persistence.*;

@Entity
public class Sensores {

	@Id @GeneratedValue
	private Long id;
	@Column(unique = true)
	private String modelo;
	private String descricao;
	// Vertice estara na implementacao da classe Sensor 
	private String tipo;
	private String dado;
	private float valorMaximo;
	private float valorMinimo;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDado() {
		return dado;
	}
	public void setDado(String dado) {
		this.dado = dado;
	}
	public float getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(float valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	public float getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
}
