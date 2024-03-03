package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoController 
{

	public void cadastrarCurso(Curso c) throws SQLException, ClassNotFoundException
	{
		System.out.println(c.toString());
	}

	public void alterarCurso(Curso c) throws SQLException, ClassNotFoundException
	{
		System.out.println(c.toString());		
	}

	public void excluirCurso(Curso c) throws SQLException, ClassNotFoundException
	{
		System.out.println(c.toString());		
	}

	public Curso buscarCurso(Curso c) throws SQLException, ClassNotFoundException
	{
		c.setNome("ads");
		c.setArea("tecnologia");
		return c;
	}
	
	public List<Curso> listarCursos() throws SQLException, ClassNotFoundException
	{
		List<Curso> cursos = new ArrayList<>();
		
		Curso c1 = new Curso();
		c1.setCodigo(1);
		c1.setNome("ads");
		c1.setArea("tecnologia");
		
		Curso c2 = new Curso();
		c2.setCodigo(2);
		c2.setNome("psicologia");
		c2.setArea("humanas");
		
		Curso c3 = new Curso();
		c3.setCodigo(3);
		c3.setNome("matematica");
		c3.setArea("exatas");
		
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		
		return cursos;
	}

}
