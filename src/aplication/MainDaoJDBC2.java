package aplication;

import model.dao.DaoFabrica;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class MainDaoJDBC2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamentoDao = DaoFabrica.criarDepartamento();
		
		System.out.println("====TESTE 4 InserirVendedor ====");
		Departamento novoDepartamento = new Departamento(null, "Finaceiro");
		departamentoDao.inserir(novoDepartamento);
		System.out.println("Inserir! Novo ID: " + novoDepartamento.getId());
	}
}
