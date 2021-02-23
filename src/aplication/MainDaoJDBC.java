package aplication;

import model.entities.Departamento;

public class MainDaoJDBC {

	public static void main(String[] args) {
		
		Departamento departamento = new Departamento(1, "Livros");
		System.out.println(departamento);

	}

}
