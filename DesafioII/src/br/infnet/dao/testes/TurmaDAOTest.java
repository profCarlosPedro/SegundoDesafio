package br.infnet.dao.testes;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import br.infnet.dao.TurmaDAO;
import br.infnet.domain.Turma;

public class TurmaDAOTest {

	@Test
	public void InserirTest() throws ClassNotFoundException, SQLException {
		Turma turma = new Turma();
		turma.setNome("Java Web I");
		TurmaDAO dao = new TurmaDAO();
		dao.inserir(turma);
		List<Turma> turmas = dao.selecionar();
		dao.excluir(2);
		
		assertTrue(turmas.size() >0);
	}

}
