package model.dao;

import dataBase.DataBase;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFabrica {
	
	public static VendedorDao criarVendedor() {
		return new VendedorDaoJDBC(DataBase.getConnection());
	}

}
