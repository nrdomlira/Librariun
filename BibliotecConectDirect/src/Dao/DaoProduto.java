package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class DaoProduto {
	static Connection conn;
	/////////////////////////////////////
	public DaoProduto(){
		try{
			if(conn == null){
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbBiblioTec","root","24556911");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////////////////////
	public void Create(Produto obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("INSERT INTO tbmaterial "
					+ "(tipo,titulo,autor1,autor2,editora,disponibilidade,reserva,dataCadastro)VALUES"+"(?,?,?,?,?,?,?,?)");

			stmt.setString(1, obj.getTipo());
			stmt.setString(2, obj.getTitulo());
			stmt.setString(3, obj.getAutor1());
			stmt.setString(4, obj.getAutor2());
			stmt.setString(5, obj.getEditora());
			stmt.setBoolean(6, true);
			stmt.setBoolean(7, false);
			stmt.setString(8, obj.getDataCadastro());

			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////////////////////
	public Produto Read(int id) {
		Produto produto=new Produto();
		try{
			PreparedStatement stmt=conn.prepareStatement("select * from tbmaterial where idMaterial=?");
			stmt.setInt(1, id);
			ResultSet res=stmt.executeQuery();

			if(res.next()){
				int matricula=res.getInt("idMaterial");
				String tipo=res.getString("tipo");
				String titulo=res.getString("titulo");
				String autor1=res.getString("autor1");
				String autor2=res.getString("autor2");
				String editora=res.getString("editora");
				boolean disponivel=res.getBoolean("disponibilidade");
				String data=res.getString("dataCadastro");

				produto.setId(matricula);
				produto.setTipo(tipo);
				produto.setTitulo(titulo);
				produto.setAutor1(autor1);
				produto.setAutor2(autor2);
				produto.setEditora(editora);
				produto.setDisponibilidade(disponivel);
				produto.setDataCadastro(data);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return produto;
	}
	/////////////////////////////////////
	public void Update(Produto obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbmaterial SET "
					+ "tipo=?,titulo=?,autor1=?,autor2=?,editora=?,disponibilidade=?,reserva=?,dataCadastro=? WHERE idMaterial=?");
			stmt.setString(1,obj.getTipo());
			stmt.setString(2, obj.getTitulo());
			stmt.setString(3, obj.getAutor1());
			stmt.setString(4, obj.getAutor2());
			stmt.setString(5, obj.getEditora());
			stmt.setBoolean(6, obj.getDisponibilidade());
			stmt.setBoolean(7, obj.getReserva());
			stmt.setString(8, obj.getDataCadastro());
			stmt.setInt(9, obj.getId());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////////////////////
	public void UpdateReservaTrue(int i) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbmaterial SET "
					+ "reserva=? WHERE idMaterial=?");
			stmt.setBoolean(1,true);
			stmt.setInt(2, i);

			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////////////////////
	public void UpdateReservaFalse(int i) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbmaterial SET "
					+ "reserva=? WHERE idMaterial=?");
			stmt.setBoolean(1,false);
			stmt.setInt(2, i);


			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/////////////////////////////////////
	public void UpdateEmprestimoTrue(Produto obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbmaterial SET "
					+ "disponibilidade=? WHERE idMaterial=?");
			stmt.setBoolean(1,false);
			stmt.setInt(2, obj.getId());

			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////////////////////
	public void UpdateEmprestimoFalse(Produto obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbmaterial SET "
					+ "disponibilidade=? WHERE idMaterial=?");
			stmt.setBoolean(1,true);
			stmt.setInt(2, obj.getId());

			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/////////////////////////////////////
	public void Delete(int id) {
		try{
			PreparedStatement stmt=conn.prepareStatement("DELETE FROM tbmaterial WHERE idMaterial=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	/////////////////////////////////////
	public List ReadAll() {
		List<Produto> ListContatos=new ArrayList<Produto>();
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from tbmaterial");

			while(res.next()){
				int matricula=res.getInt("idMaterial");
				String tipo=res.getString("tipo");
				String titulo=res.getString("titulo");
				String autor1=res.getString("autor1");
				String autor2=res.getString("autor2");
				String editora=res.getString("editora");
				boolean disponivel=res.getBoolean("disponibilidade");
				String data=res.getString("dataCadastro");

				Produto produto=new Produto();

				produto.setId(matricula);
				produto.setTipo(tipo);
				produto.setTitulo(titulo);
				produto.setAutor1(autor1);
				produto.setAutor2(autor2);
				produto.setEditora(editora);
				produto.setDisponibilidade(disponivel);
				produto.setDataCadastro(data);

				ListContatos.add(produto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ListContatos;
	}
	/////////////////////////////////////
	public List ReadAllDisponiveisEmprestimo() {
		List<Produto> ListContatos=new ArrayList<Produto>();
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from tbmaterial WHERE disponibilidade="+true+" and reserva="+false);

			while(res.next()){
				int matricula=res.getInt("idMaterial");
				String tipo=res.getString("tipo");
				String titulo=res.getString("titulo");
				String autor1=res.getString("autor1");
				String autor2=res.getString("autor2");
				String editora=res.getString("editora");
				boolean disponivel=res.getBoolean("disponibilidade");
				String data=res.getString("dataCadastro");

				Produto produto=new Produto();

				produto.setId(matricula);
				produto.setTipo(tipo);
				produto.setTitulo(titulo);
				produto.setAutor1(autor1);
				produto.setAutor2(autor2);
				produto.setEditora(editora);
				produto.setDisponibilidade(disponivel);
				produto.setDataCadastro(data);

				ListContatos.add(produto);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return ListContatos;
	}
	/////////////////////////////////////
	public List ReadAllDisponiveisReserva() {
		List<Produto> ListContatos=new ArrayList<Produto>();
		try{
			Statement stmt=(Statement) conn.createStatement();                      //não aparece se ja estiver empres
			ResultSet res=stmt.executeQuery("select * from tbmaterial WHERE disponibilidade="+true+" and reserva="+false);

			while(res.next()){
				int matricula=res.getInt("idMaterial");
				String tipo=res.getString("tipo");
				String titulo=res.getString("titulo");
				String autor1=res.getString("autor1");
				String autor2=res.getString("autor2");
				String editora=res.getString("editora");
				boolean disponivel=res.getBoolean("disponibilidade");
				String data=res.getString("dataCadastro");

				Produto produto=new Produto();

				produto.setId(matricula);
				produto.setTipo(tipo);
				produto.setTitulo(titulo);
				produto.setAutor1(autor1);
				produto.setAutor2(autor2);
				produto.setEditora(editora);
				produto.setDisponibilidade(disponivel);
				produto.setDataCadastro(data);

				ListContatos.add(produto);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return ListContatos;
	}

}
