package aplication;

import java.util.List;

import model.dao.DaoFabrica;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class MainDaoJDBC2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamentoDao = DaoFabrica.criarDepartamento();
		
		System.out.println("====TESTE 1 InserirDepartamento ====");
		Departamento novoDepartamento = new Departamento(null, "Finaceiro");
		//departamentoDao.inserir(novoDepartamento);
		System.out.println("Inserir! Novo ID: " + novoDepartamento.getId());
		
		System.out.println("====TESTE 2 Buscar por Id departamento ====");
		Departamento departamento = departamentoDao.buscarPorId(2);
		System.out.println(departamento);
		
		System.out.println("====TESTE 3 Atualizar departamento ====");
		departamento = departamentoDao.buscarPorId(2);
		departamento.setNome("Livros");
		departamentoDao.atualizar(departamento);
		System.out.println("Atualizado!");
		
		System.out.println("====TESTE 4 Deletar departamento ====");
		departamentoDao.deletarPorId(8);
		System.out.println("Deletado!");
		
		System.out.println("====TESTE 5 Buscar todos departamento ====");
		List<Departamento> todosDepartamentos = departamentoDao.buscarTodos();
		for(Departamento departamentos : todosDepartamentos) {
			System.out.println(departamentos);
		}
	}
}
