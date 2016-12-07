package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

public class DaoReserva {
	static Connection conn;
	public DaoReserva(){
		try{
			if(conn == null){
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbBiblioTec","root","24556911");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////
	public void Create(Reserva obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("INSERT INTO tbreserva "
					+ "(dataReserva,dataLimite,aluno_id,material_id)VALUES"+"(?,?,?,?)");
			stmt.setString(1,obj.getDataReserva());
			stmt.setString(2, obj.getDataLimite());
			stmt.setString(3, obj.getAlunoId());
			stmt.setString(4, obj.getProdutoId());

			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	/////////////////////
	public Reserva Read(int id) {
		Reserva reserva=new Reserva();
		try{
			PreparedStatement stmt=conn.prepareStatement("select * from tbreserva where id=?");
			stmt.setInt(1, id);
			ResultSet res=stmt.executeQuery();

			if(res.next()){
				int iD=res.getInt("id");
				int alunoId=res.getInt("aluno_id");
				int produtoId=res.getInt("material_id");
				String data=res.getString("dataReserva");
				String dataLimite=res.getString("dataLimite");

				
				reserva.setId(iD);
				reserva.setAlunoId(Integer.toString(alunoId));
				reserva.setProdutoId(Integer.toString(produtoId));
				reserva.setDataLimite(dataLimite);
				reserva.setDataReserva(data);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return reserva;
	}
	/////////////////////
	public void Update(Reserva obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbreserva SET "
					+ "aluno_id=?,material_id=?,dataReserva=?,dataLimite=? WHERE id=?");
			stmt.setString(1, obj.getAlunoId());
			stmt.setString(2, obj.getProdutoId());
			stmt.setString(3, obj.getDataReserva());
			stmt.setString(4, obj.getDataLimite());
			
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////
	public void Delete(int id) {
		try{
			PreparedStatement stmt=conn.prepareStatement("DELETE FROM tbreserva WHERE id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	/////////////////////
	public List ReadAll() {
		List<Reserva> ListReserva=new ArrayList<Reserva>();
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from tbreserva");

			while(res.next()){
				int iD=res.getInt("id");
				int alunoId=res.getInt("aluno_id");
				int produtoId=res.getInt("material_id");
				String data=res.getString("dataReserva");
				String dataLimite=res.getString("dataLimite");
				
				Reserva reserva=new Reserva();
				reserva.setId(iD);
				reserva.setAlunoId(Integer.toString(alunoId));
				reserva.setProdutoId(Integer.toString(produtoId));
				reserva.setDataLimite(dataLimite);
				reserva.setDataReserva(data);

				ListReserva.add(reserva);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return ListReserva;
	}

}
