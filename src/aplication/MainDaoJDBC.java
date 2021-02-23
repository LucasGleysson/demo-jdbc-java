package aplication;

import java.util.Date;

import model.dao.DaoFabrica;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class MainDaoJDBC {

	public static void main(String[] args) {
		
		Departamento departamento = new Departamento(1, "Livros");
		Vendedor vendedor = new Vendedor(2, "Bruno", "bruno@gmail.com", new Date(), 4000.0, departamento);
		System.out.println(vendedor);
		
		VendedorDao vendedorDao = DaoFabrica.criarVendedor();

	}

}
