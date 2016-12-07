package Dao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import com.mysql.jdbc.Statement;

public class DaoEmprestimo {
	static Connection conn;
	public DaoEmprestimo(){
		try{
			if(conn == null){
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbBiblioTec","root","24556911");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void Create(Emprestimo obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("INSERT INTO tbemprestimo "
					+ "(id,data_Saida,data_devolucao,aluno_id,material_id)VALUES"+"(?,?,?,?,?)");
			
			stmt.setInt(1,obj.getId());
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String data=dateFormat.format(date);
			stmt.setString(2,data);
			
			GregorianCalendar gc=new GregorianCalendar();
			 gc.add(gc.DATE, 15); //Adiciona 2 meses à data atual
			 Date d1=gc.getTime();
			stmt.setString(3,dateFormat.format(d1));
			
			stmt.setInt(4, obj.getAlunoId());
			stmt.setInt(5,obj.getMaterialId());	
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public Emprestimo Read(int id) {
		Emprestimo emprestimo=new Emprestimo();
		try{
			PreparedStatement stmt=conn.prepareStatement("select * from tbemprestimo where id=?");
			stmt.setInt(1, id);
			ResultSet res=stmt.executeQuery();

			if(res.next()){
				int iD=res.getInt("id");
				String dataSaida=res.getString("data_Saida");
				String dataDevolu=res.getString("data_devolucao");
				int alunoId=res.getInt("aluno_id");
				int materialId=res.getInt("material_id");

				emprestimo.setId(iD);
				emprestimo.setDataSaida(dataSaida);
				emprestimo.setDataRetorno(dataDevolu);
				emprestimo.setAlunoId(alunoId);
				emprestimo.setMaterialId(materialId);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return emprestimo;
	}

	public void Update(Emprestimo obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbemprestimo SET "
					+ "data_Saida=?,data_devolucao=?,aluno_id=?,material_id=? WHERE id=?");
			stmt.setString(1,obj.getDataSaida());
			stmt.setString(2, obj.getDataRetorno());
			stmt.setInt(3, obj.getAlunoId());
			stmt.setInt(4, obj.getMaterialId());
			stmt.setInt(5, obj.getId());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void Delete(int id) {
		try{
			PreparedStatement stmt=conn.prepareStatement("DELETE FROM tbemprestimo WHERE id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}


	public List ReadAll() {
		List<Emprestimo> ListEmprestimos=new ArrayList<Emprestimo>();
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from tbemprestimo");

			while(res.next()){
				int iD=res.getInt("id");
				String dataSaida=res.getString("data_Saida");
				String dataDevolu=res.getString("data_devolucao");
				int alunoId=res.getInt("aluno_id");
				int materialId=res.getInt("material_id");
				
				Emprestimo emprestimo=new Emprestimo();
				emprestimo.setId(iD);
				emprestimo.setDataSaida(dataSaida);
				emprestimo.setDataRetorno(dataDevolu);
				emprestimo.setAlunoId(alunoId);
				emprestimo.setMaterialId(materialId);

				ListEmprestimos.add(emprestimo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return ListEmprestimos;
	}
	public List ReadAllDoDIa() {
		List<Emprestimo> ListEmprestimos=new ArrayList<Emprestimo>();
		try{
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String data=dateFormat.format(date);
			
			Statement stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from tbemprestimo");

			while(res.next()){
				int iD=res.getInt("id");
				String dataSaida=res.getString("data_Saida");
				String dataDevolu=res.getString("data_devolucao");
				int alunoId=res.getInt("aluno_id");
				int materialId=res.getInt("material_id");
				if(data.equals(dataDevolu)){
					
				
				Emprestimo emprestimo=new Emprestimo();
				emprestimo.setId(iD);
				emprestimo.setDataSaida(dataSaida);
				emprestimo.setDataRetorno(dataDevolu);
				emprestimo.setAlunoId(alunoId);
				emprestimo.setMaterialId(materialId);

				ListEmprestimos.add(emprestimo);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return ListEmprestimos;
	}
}
