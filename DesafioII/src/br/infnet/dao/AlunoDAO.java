package br.infnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.infnet.domain.Aluno;
import br.infnet.domain.Turma;

public class AlunoDAO extends BaseDAO {

	
	private final String strAlunosPorTurma =  "SELECT a.\"matricula\", a.\"nome\", (select count(*) from \"TurmaAluno\" ta where  ta.\"matricula\" = a.\"matricula\" and  ta.\"IdTurma\" = ?) \"Inscrito\" FROM \"Aluno\" a";
	

	
	public void inserir(Aluno aluno) throws ClassNotFoundException,
			SQLException {
		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("INSERT INTO \"Aluno\" (\"matricula\", \"nome\") VALUES (?, ?)");
		query.setString(1, aluno.getMatricula());
		query.setString(2, aluno.getNome());
		query.execute();

	}

	public List<Aluno> selecionarPorTurma(int IdTurma) throws ClassNotFoundException, SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement(strAlunosPorTurma);
		query.setInt(1, IdTurma);
		
		ResultSet resultados = query.executeQuery();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		while (resultados.next()) {
			Aluno aluno = new Aluno();
			aluno.setMatricula(resultados.getString("matricula"));
			aluno.setNome(resultados.getString("nome"));
			long inscrito = resultados.getLong("inscrito");
			if (inscrito > 0)
			{
				Turma turma = new Turma();
				turma.setId(IdTurma);
				List<Turma> turmas = new ArrayList<Turma>();
				turmas.add(turma);
				aluno.setTurmas(turmas);
			}
			
			alunos.add(aluno);
		}
		return alunos;

	}

	
	public List<Aluno> selecionar() throws ClassNotFoundException, SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("SELECT \"matricula\", \"nome\" from \"Aluno\"");

		ResultSet resultados = query.executeQuery();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		while (resultados.next()) {
			Aluno aluno = new Aluno();
			aluno.setMatricula(resultados.getString("matricula"));
			aluno.setNome(resultados.getString("nome"));
			alunos.add(aluno);
		}
		return alunos;

	}

	public Aluno selecionar(String matricula) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("SELECT \"matricula\", \"nome\" from \"Aluno\" where \"matricula\" = ?");
		query.setString(1, matricula);
		ResultSet resultados = query.executeQuery();
		Aluno aluno = null;
		if (resultados.next()) {
			aluno = new Aluno();
			aluno.setMatricula(resultados.getString("matricula"));
			aluno.setNome(resultados.getString("nome"));

		}
		return aluno;

	}
	
	
	

	public void atualizar(Aluno aluno) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("update \"Aluno\" set \"nome\"=? where \"matricula\"= ?");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getMatricula());
		query.execute();

	}

	public void excluir(String matricula) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("delete from \"Aluno\" where \"matricula\"= ?");
		query.setString(1, matricula);
		query.execute();

	}

}
