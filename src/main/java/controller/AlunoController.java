package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoController 
{
	public void cadastrarAluno(Aluno a) throws SQLException, ClassNotFoundException
	{
		System.out.println(a.toString());
	}

	public void alterarAluno(Aluno a) throws SQLException, ClassNotFoundException
	{
		System.out.println(a.toString());		
	}

	public void excluirAluno(Aluno a) throws SQLException, ClassNotFoundException
	{
		System.out.println(a.toString());		
	}

	public Aluno buscarAluno(Aluno a) throws SQLException, ClassNotFoundException
	{
		a.setNome("ads");
		a.setIdade(1);
		return a;
	}
	
	public List<Aluno> listarAlunos() throws SQLException, ClassNotFoundException
	{
		List<Aluno> alunos = new ArrayList<>();
		
		Aluno a1 = new Aluno();
		a1.setRa(1);
		a1.setNome("ads");
		a1.setIdade(6);
		
		Aluno a2 = new Aluno();
		a2.setRa(2);
		a2.setNome("psicologia");
		a2.setIdade(3);
		
		Aluno a3 = new Aluno();
		a3.setRa(3);
		a3.setNome("matematica");
		a3.setIdade(4);
		
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		
		return alunos;
	}
}
