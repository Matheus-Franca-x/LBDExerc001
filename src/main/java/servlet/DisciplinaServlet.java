package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Disciplina;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.DisciplinaController;

@WebServlet("/disciplina")
public class DisciplinaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public DisciplinaServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Apenas carrega disciplina.jsp sem nenhum elemento
		List<Disciplina> disciplinas = new ArrayList<>();
		DisciplinaController dControl = new DisciplinaController();
		
		try {
			disciplinas = dControl.listarDisciplinas();
		} catch (SQLException | ClassNotFoundException e)
		{
			System.err.print(e);
		} finally {
			request.setAttribute("disciplinas", disciplinas);
			
			RequestDispatcher rd = request.getRequestDispatcher("disciplina.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//entrada
		String cmd = request.getParameter("botao");
		String codigo = request.getParameter("codigoDisciplina");
		String nome = request.getParameter("nomeDisciplina");
		String cargaHoraria = request.getParameter("cargaHorariaDisciplina");
		List<Disciplina> disciplinas = new ArrayList<>();
		
		//saida
		String saida = "";
		String erro = "";
		Disciplina d = new Disciplina();
		DisciplinaController dControl = new DisciplinaController();
		
		if(!cmd.contains("Cadastrar") || !cmd.contains("Alterar"))
		{
			d.setNome(nome);
			if(!cargaHoraria.strip().equals(""))
			{
				d.setCargaHoraria(Integer.parseInt(cargaHoraria));
			}
			else {
				d.setCargaHoraria(0);
			}
		}
		try {
			disciplinas = dControl.listarDisciplinas();
			if(cmd.contains("Cadastrar"))
			{
				dControl.cadastrarDisciplina(d);
				saida = "Disciplina cadastrado com sucesso!";
				d = null;
			}
			if(cmd.contains("Alterar"))
			{
				dControl.alterarDisciplina(d);
				saida = "Disciplina alterado com sucesso!";
				d = null;
			}
			if(cmd.contains("Excluir"))
			{
				dControl.excluirDisciplina(d);
				saida = "Disciplina excluido com sucesso!";
				d = null;
			}
			if(cmd.contains("Buscar"))
			{
				d = dControl.buscarDisciplina(d);
			}
		} catch (SQLException | ClassNotFoundException e)
		{
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("disciplina", d);
			request.setAttribute("disciplinas", disciplinas);
			
			RequestDispatcher rd = request.getRequestDispatcher("disciplina.jsp");
			rd.forward(request, response);
		}
		
	}

}
