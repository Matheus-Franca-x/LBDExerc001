package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class DisciplinaController 
{
	public void cadastrarDisciplina(Disciplina a) throws SQLException, ClassNotFoundException
	{
		System.out.println(a.toString());
	}

	public void alterarDisciplina(Disciplina a) throws SQLException, ClassNotFoundException
	{
		System.out.println(a.toString());		
	}

	public void excluirDisciplina(Disciplina a) throws SQLException, ClassNotFoundException
	{
		System.out.println(a.toString());		
	}

	public Disciplina buscarDisciplina(Disciplina a) throws SQLException, ClassNotFoundException
	{
		a.setNome("ads");
		a.setCargaHoraria(1);
		return a;
	}
	
	public List<Disciplina> listarDisciplinas() throws SQLException, ClassNotFoundException
	{
		List<Disciplina> disciplinas = new ArrayList<>();
		
		Disciplina d1 = new Disciplina();
		d1.setCodigo(1);
		d1.setNome("ads");
		d1.setCargaHoraria(6);
		
		Disciplina d2 = new Disciplina();
		d2.setCodigo(2);
		d2.setNome("psicologia");
		d2.setCargaHoraria(3);
		
		Disciplina d3 = new Disciplina();
		d3.setCodigo(3);
		d3.setNome("matematica");
		d3.setCargaHoraria(4);
		
		disciplinas.add(d1);
		disciplinas.add(d2);
		disciplinas.add(d3);
		
		return disciplinas;
	}
}
