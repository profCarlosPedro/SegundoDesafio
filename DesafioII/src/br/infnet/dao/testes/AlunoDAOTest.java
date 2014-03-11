package br.infnet.dao.testes;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.infnet.dao.AlunoDAO;
import br.infnet.domain.Aluno;

public class AlunoDAOTest {

	@Test
	public void SelectTest() throws ClassNotFoundException, SQLException {
		br.infnet.dao.AlunoDAO dao = new AlunoDAO();
		List<br.infnet.domain.Aluno> aluno = dao.selecionarPorTurma(1);
		assertTrue(aluno.size() ==0);
	}
	
	@Test
	public void InsertTest() throws ClassNotFoundException, SQLException {
		br.infnet.dao.AlunoDAO dao = new AlunoDAO();
		Aluno aluno = new Aluno();
		aluno.setMatricula("123");
		aluno.setNome("Carlos" );
		dao.inserir(aluno);
		List<Aluno> alunos = dao.selecionar();
		assertTrue(alunos.size() > 0);
	}
	
	@Test
	public void AtualizarTest() throws ClassNotFoundException, SQLException {
		br.infnet.dao.AlunoDAO dao = new AlunoDAO();
		Aluno aluno = new Aluno();
		aluno.setMatricula("123");
		aluno.setNome("Carlos Pddfo" );
		dao.atualizar(aluno);
		List<Aluno> alunos = dao.selecionar();
		assertTrue(alunos.size() > 0);
	}
	
	
	@Test
	public void ExcluirTest() throws ClassNotFoundException, SQLException {
		br.infnet.dao.AlunoDAO dao = new AlunoDAO();
		Aluno aluno = new Aluno();
		aluno.setMatricula("123");
		aluno.setNome("Carlos" );
		dao.excluir("123");
		List<Aluno> alunos = dao.selecionar();
		assertTrue(alunos.size() == 0);
	}
	

}
