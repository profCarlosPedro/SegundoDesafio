package edu.infnet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.infnet.dao.AlunoDAO;
import br.infnet.dao.TurmaDAO;
import br.infnet.domain.Aluno;
import br.infnet.domain.Turma;

/**
 * Servlet implementation class GerenciarTurma
 */
@WebServlet("/GerenciarTurma")
public class GerenciarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciarTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		AlunoDAO dao = new AlunoDAO();
		try {
			List<Aluno> alunos = dao.selecionarPorTurma(id);
			TurmaDAO turmadao = new TurmaDAO();
			Turma turma = turmadao.selecionar(id);
			request.setAttribute("alunolist", alunos);
			request.setAttribute("turma", turma);
			request.getRequestDispatcher("GestaoTurma.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
