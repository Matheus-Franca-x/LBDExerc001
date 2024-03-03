package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class ProfessorController 
{
	public void cadastrarProfessor(Professor p) throws SQLException, ClassNotFoundException
	{
		System.out.println(p.toString());
	}

	public void alterarProfessor(Professor p) throws SQLException, ClassNotFoundException
	{
		System.out.println(p.toString());		
	}

	public void excluirProfessor(Professor p) throws SQLException, ClassNotFoundException
	{
		System.out.println(p.toString());		
	}

	public Professor buscarProfessor(Professor p) throws SQLException, ClassNotFoundException
	{
		p.setNome("Leandro");
		p.setTitulacao("teste");
		return p;
	}
	
	public List<Professor> listarProfessors() throws SQLException, ClassNotFoundException
	{
		List<Professor> professores = new ArrayList<>();
		
		Professor p1 = new Professor();
		p1.setRegistro(1);
		p1.setNome("ads");
		p1.setTitulacao("teste");
		
		Professor p2 = new Professor();
		p2.setRegistro(2);
		p2.setNome("psicologia");
		p2.setTitulacao("teste");
		
		Professor p3 = new Professor();
		p3.setRegistro(3);
		p3.setNome("matematica");
		p3.setTitulacao("teste");
		
		professores.add(p1);
		professores.add(p2);
		professores.add(p3);
		
		return professores;
	}
}
