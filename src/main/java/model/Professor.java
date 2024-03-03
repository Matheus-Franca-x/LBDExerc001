package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Professor
{
	int registro;
	String nome;
	String titulacao;
	
	public Professor(int registro, String nome, Titulacao titulacao)
	{
		this.registro = registro;
		this.nome = nome;
		this.titulacao = titulacao.getTitulo();
	}
}
