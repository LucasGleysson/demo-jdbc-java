package aplication;

import java.util.Date;
import java.util.List;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class MainDaoJDBC {

	public static void main(String[] args) {
		
		System.out.println("====TESTE 1 BuscarPorId ====");
		VendedorDao vendedorDao = DaoFabrica.criarVendedor();
		Vendedor vendedor = vendedorDao.buscarPorId(3);
		System.out.println(vendedor);

		System.out.println("====TESTE 2 BuscarPorDepartamento ====");
		Departamento dep = new Departamento(2,null);
		List<Vendedor> lista = vendedorDao.buscarPorDepartamento(dep);
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		
		System.out.println("====TESTE 3 BuscarTodos ====");
		lista = vendedorDao.buscarTodos();
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		
		System.out.println("====TESTE 4 InserirVendedor ====");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		vendedorDao.inserir(novoVendedor);
		System.out.println("Inserir! Novo ID: " + novoVendedor.getId());
		
		System.out.println("====TESTE 5 AtualizarVendedor ====");
		vendedor = vendedorDao.buscarPorId(1);
		vendedor.setNome("Marta Birth");
		vendedorDao.atualizar(vendedor);
		System.out.println("Atualizado");
	}

}
