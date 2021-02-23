package aplication;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class MainDaoJDBC {

	public static void main(String[] args) {
		
		System.out.println("====TESTE 1 BuscarPorId ====");
		VendedorDao vendedorDao = DaoFabrica.criarVendedor();
		Vendedor vendedor = vendedorDao.buscarPorId(3);
		System.out.println(vendedor);

	}

}
