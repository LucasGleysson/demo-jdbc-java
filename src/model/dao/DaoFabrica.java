package model.dao;

import model.dao.impl.VendedorDaoJDBC;

public class DaoFabrica {
	
	public static VendedorDao criarVendedor() {
		return new VendedorDaoJDBC();
	}

}
