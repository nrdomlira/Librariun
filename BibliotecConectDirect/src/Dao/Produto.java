package Dao;

public class Produto {
	private int id;
	private String tipo,titulo,autor1,autor2,editora,dataCadastro;
	private boolean disponibilidade,reserva;
	
	
	public boolean getReserva() {
		return reserva;
	}
	public void setReserva(boolean reserva) {
		this.reserva = reserva;
	}
	public boolean getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor1() {
		return autor1;
	}
	public void setAutor1(String autor1) {
		this.autor1 = autor1;
	}
	public String getAutor2() {
		return autor2;
	}
	public void setAutor2(String autor2) {
		this.autor2 = autor2;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

		
}
