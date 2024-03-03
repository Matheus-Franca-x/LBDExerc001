package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.AlunoController;

@WebServlet("/aluno")
public class AlunoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public AlunoServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Apenas carrega Aluno.jsp sem nenhum elemento
		List<Aluno> alunos = new ArrayList<>();
		AlunoController aControl = new AlunoController();
		
		try {
			alunos = aControl.listarAlunos();
		} catch (SQLException | ClassNotFoundException e)
		{
			System.err.print(e);
		} finally {
			request.setAttribute("alunos", alunos);
			
			RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//entrada
		String cmd = request.getParameter("botao");
		String ra = request.getParameter("raAluno");
		String nome = request.getParameter("nomeAluno");
		String idade = request.getParameter("idadeAluno");
		
		//saida
		String saida = "";
		String erro = "";
		Aluno a = new Aluno();
		AlunoController aControl = new AlunoController();
		
		if(!cmd.contains("Cadastrar") || !cmd.contains("Alterar"))
		{
			a.setNome(nome);
			a.setIdade(Integer.parseInt(idade));
		}
		try {
			if(cmd.contains("Cadastrar"))
			{
				aControl.cadastrarAluno(a);
				saida = "Aluno cadastrado com sucesso!";
				a = null;
			}
			if(cmd.contains("Alterar"))
			{
				aControl.alterarAluno(a);
				saida = "Aluno alterado com sucesso!";
				a = null;
			}
			if(cmd.contains("Excluir"))
			{
				aControl.excluirAluno(a);
				saida = "Aluno excluido com sucesso!";
				a = null;
			}
			if(cmd.contains("Buscar"))
			{
				a = aControl.buscarAluno(a);
			}
		} catch (SQLException | ClassNotFoundException e)
		{
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("Aluno", a);
			
			RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
			rd.forward(request, response);
		}
		
	}

}
