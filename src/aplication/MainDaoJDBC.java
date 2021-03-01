package aplication;

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
		Departamento dep = new Departamento(1,null);
		List<Vendedor> lista = vendedorDao.buscarPorDepartamento(dep);
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
	}

}
