package Dao;

public class Emprestimo {
private int id;
private int alunoId;
private int materialId;
private String dataSaida;
private String dataRetorno;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAlunoId() {
	return alunoId;
}
public void setAlunoId(int alunoId) {
	this.alunoId = alunoId;
}
public int getMaterialId() {
	return materialId;
}
public void setMaterialId(int materialId) {
	this.materialId = materialId;
}
public String getDataSaida() {
	return dataSaida;
}
public void setDataSaida(String dataSaida) {
	this.dataSaida = dataSaida;
}
public String getDataRetorno() {
	return dataRetorno;
}
public void setDataRetorno(String dataRetorno) {
	this.dataRetorno = dataRetorno;
}


}
