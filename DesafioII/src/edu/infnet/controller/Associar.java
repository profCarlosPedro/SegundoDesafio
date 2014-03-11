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
 * Servlet implementation class Associar
 */
@WebServlet("/Associar")
public class Associar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Associar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String matricula = request.getParameter("matricula");
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		try {
			TurmaDAO turmadao = new TurmaDAO();
			if (tipo == 0)
				turmadao.associar(id, matricula);
			else
				turmadao.desassociar(id, matricula);
			
			request.setAttribute("id", id);
			request.getRequestDispatcher("GerenciarTurma").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
