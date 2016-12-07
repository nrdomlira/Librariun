package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;

public class DaoAluno {
	static Connection conn;

	public DaoAluno(){
		try{
			if(conn == null){
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbBiblioTec","root","24556911");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void Create(Aluno obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("INSERT INTO tbaluno "
					+ "(matriculaAluno,cpfAluno,nomeAluno,nascimentoAluno,telefoneAluno)VALUES"+"(?,?,?,?,?)");
			stmt.setInt(1,obj.getMatricula());
			stmt.setString(2,obj.getCpf());
			stmt.setString(3,obj.getNome());
			stmt.setString(4, obj.getData());
			stmt.setString(5,obj.getTelefone());	
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public Aluno Read(int id) {
		Aluno aluno=new Aluno();
		try{
			PreparedStatement stmt=conn.prepareStatement("select * from tbaluno where matriculaAluno=?");
			stmt.setInt(1, id);
			ResultSet res=stmt.executeQuery();

			if(res.next()){
				int matricula=res.getInt("matriculaAluno");
				String cpf=res.getString("cpfAluno");
				String nome=res.getString("nomeAluno");
				String nascimento=res.getString("nascimentoAluno");
				String telefone=res.getString("telefoneAluno");

				aluno.setMatricula(matricula);
				aluno.setCpf(cpf);
				aluno.setNome(nome);
				aluno.setData(nascimento);
				aluno.setTelefone(telefone);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return aluno;
	}
	public Aluno ReadCpf(String cpff){
		Aluno aluno=new Aluno();
		try{
			PreparedStatement stmt=conn.prepareStatement("select * from tbaluno where cpfAluno=?");
			stmt.setString(1, cpff);
			ResultSet res=stmt.executeQuery();

			if(res.next()){
				int matricula=res.getInt("matriculaAluno");
				String cpf=res.getString("cpfAluno");
				String nome=res.getString("nomeAluno");
				String nascimento=res.getString("nascimentoAluno");
				String telefone=res.getString("telefoneAluno");

				aluno.setMatricula(matricula);
				aluno.setCpf(cpf);
				aluno.setNome(nome);
				aluno.setData(nascimento);
				aluno.setTelefone(telefone);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return aluno;
	}

	public void Update(Aluno obj) {
		try{
			PreparedStatement stmt=conn.prepareStatement("UPDATE tbaluno SET "
					+ "cpfAluno=?,nomeAluno=?,nascimentoAluno=?,telefoneAluno=? WHERE matriculaAluno=?");
			stmt.setString(1,obj.getCpf());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getData());
			stmt.setString(4, obj.getTelefone());
			stmt.setInt(5, obj.getMatricula());
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void Delete(int id) {
		try{
			PreparedStatement stmt=conn.prepareStatement("DELETE FROM tbaluno WHERE matriculaAluno=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}

	}


	public List ReadAll() {
		List<Aluno> ListContatos=new ArrayList<Aluno>();
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet res=stmt.executeQuery("select * from tbaluno");

			while(res.next()){
				int matricula=res.getInt("matriculaAluno");
				String cpf=res.getString("cpfAluno");
				String nome=res.getString("nomeAluno");
				String nascimento=res.getString("nascimentoAluno");
				String telefone=res.getString("telefoneAluno");

				Aluno aluno=new Aluno();

				aluno.setMatricula(matricula);
				aluno.setCpf(cpf);
				aluno.setNome(nome);
				aluno.setData(nascimento);
				aluno.setTelefone(telefone);

				ListContatos.add(aluno);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return ListContatos;
	}

}
