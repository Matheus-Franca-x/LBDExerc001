package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Professor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ProfessorController;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ProfessorServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Apenas carrega professor.jsp sem nenhum elemento
		List<Professor> professores = new ArrayList<>();
		ProfessorController pControl = new ProfessorController();
		
		try {
			professores = pControl.listarProfessors();
		} catch (SQLException | ClassNotFoundException e)
		{
			System.err.print(e);
		} finally {
			request.setAttribute("professores", professores);
			
			RequestDispatcher rd = request.getRequestDispatcher("professor.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//entrada
		String cmd = request.getParameter("botao");
		String registro = request.getParameter("registroProfessor");
		String nome = request.getParameter("nomeProfessor");
		String titulacao = request.getParameter("titulacaoProfessor");
		List<Professor> professores = new ArrayList<>();
		
		//saida
		String saida = "";
		String erro = "";
		Professor p = new Professor();
		ProfessorController pControl = new ProfessorController();
		
		if(!cmd.contains("Cadastrar") || !cmd.contains("Alterar"))
		{
			p.setNome(nome);
			p.setTitulacao(titulacao);
		}
		try {
			professores = pControl.listarProfessors();
			if(cmd.contains("Cadastrar"))
			{
				pControl.cadastrarProfessor(p);
				saida = "Professor cadastrado com sucesso!";
				p = null;
			}
			if(cmd.contains("Alterar"))
			{
				pControl.alterarProfessor(p);
				saida = "Professor alterado com sucesso!";
				p = null;
			}
			if(cmd.contains("Excluir"))
			{
				pControl.excluirProfessor(p);
				saida = "Professor excluido com sucesso!";
				p = null;
			}
			if(cmd.contains("Buscar"))
			{
				p = pControl.buscarProfessor(p);
			}
		} catch (SQLException | ClassNotFoundException e)
		{
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("professor", p);
			request.setAttribute("professores", professores);
			
			RequestDispatcher rd = request.getRequestDispatcher("professor.jsp");
			rd.forward(request, response);
		}
		
	}

}
