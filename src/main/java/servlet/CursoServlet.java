package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.CursoController;

@WebServlet("/curso")
public class CursoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public CursoServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Apenas carrega curso.jsp sem nenhum elemento
		List<Curso> cursos = new ArrayList<>();
		CursoController cControl = new CursoController();
		
		try {
			cursos = cControl.listarCursos();
		} catch (SQLException | ClassNotFoundException e)
		{
			System.err.print(e);
		} finally {
			request.setAttribute("cursos", cursos);
			
			RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigoCurso");
		String nome = request.getParameter("nomeCurso");
		String area = request.getParameter("areaCurso");
		List<Curso> cursos = new ArrayList<>();
		
		//saida
		String saida = "";
		String erro = "";
		Curso c = new Curso();
		CursoController cControl = new CursoController();
		
		if(!cmd.contains("Cadastrar") || !cmd.contains("Alterar"))
		{
			c.setNome(nome);
			c.setArea(area);
		}
		try {
			cursos = cControl.listarCursos();
			if(cmd.contains("Cadastrar"))
			{
				cControl.cadastrarCurso(c);
				saida = "Curso cadastrado com sucesso!";
				c = null;
			}
			if(cmd.contains("Alterar"))
			{
				cControl.alterarCurso(c);
				saida = "Curso alterado com sucesso!";
				c = null;
			}
			if(cmd.contains("Excluir"))
			{
				cControl.excluirCurso(c);
				saida = "Curso excluido com sucesso!";
				c = null;
			}
			if(cmd.contains("Buscar"))
			{
				c = cControl.buscarCurso(c);
			}
		} catch (SQLException | ClassNotFoundException e)
		{
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("curso", c);
			request.setAttribute("cursos", cursos);
			
			RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
			rd.forward(request, response);
		}
		
	}

}
