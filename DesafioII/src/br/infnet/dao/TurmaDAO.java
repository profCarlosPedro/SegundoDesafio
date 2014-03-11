package br.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.infnet.domain.Turma;

public class TurmaDAO extends BaseDAO {

	private final String strSelect = "select \"Id\", \"Nome\" from \"Turma\"";
	private final String strSelectById = "select \"Id\", \"Nome\" from \"Turma\" where \"Id\" = ? ";
	private final String strInsert = "insert into \"Turma\" ( \"Nome\" ) values (?)";
	private final String strUpdate = "update \"Turma\" set  \"Nome\"  = ? where \"Id\" = ? ";
	private final String strDelete = "delete from  \"Turma\"  where \"Id\" = ? ";

	private final String strAssociar = "insert into \"TurmaAluno\" ( \"matricula\", \"IdTurma\" ) values (?,?)";
	private final String strDesAssociar = "delete from  \"TurmaAluno\"  where \"IdTurma\" = ? and \"matricula\" = ?  ";
	

	
	public void inserir(Turma turma) throws ClassNotFoundException,
			SQLException {
		Connection conexao = getConexao();
		PreparedStatement query = conexao.prepareStatement(strInsert);
		query.setString(1, turma.getNome());
		query.execute();

	}

	public void associar(int idTurma, String matricula) throws ClassNotFoundException, SQLException
	{

		Connection conexao = getConexao();
		PreparedStatement query = conexao.prepareStatement(strAssociar);
		query.setString(1, matricula);
		query.setInt(2, idTurma);
		query.execute();
		
		
	}
	
	public void desassociar(int idTurma, String matricula) throws ClassNotFoundException, SQLException
	{
		

		Connection conexao = getConexao();
		PreparedStatement query = conexao.prepareStatement(strDesAssociar);
		query.setString(2, matricula);
		query.setInt(1, idTurma);
		query.execute();
		
	}
	
	public List<Turma> selecionar() throws ClassNotFoundException, SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao.prepareStatement(strSelect);

		ResultSet resultados = query.executeQuery();
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		while (resultados.next()) {
			Turma turma = new Turma();
			turma.setId(resultados.getInt("id"));
			turma.setNome(resultados.getString("nome"));
			turmas.add(turma);
		}
		return turmas;

	}

	public Turma selecionar(int id) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao.prepareStatement(strSelectById);
		query.setInt(1, id);
		ResultSet resultados = query.executeQuery();
		Turma turma = null;
		if (resultados.next()) {
			turma = new Turma();
			turma.setId(resultados.getInt("id"));
			turma.setNome(resultados.getString("nome"));

		}
		return turma;

	}

	public void atualizar(Turma turma) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao.prepareStatement(strUpdate);
		query.setString(1, turma.getNome());
		query.setInt(2, turma.getId());
		query.execute();

	}

	public void excluir(int id) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao.prepareStatement(strDelete);
		query.setInt(1, id);
		query.execute();

	}

}
