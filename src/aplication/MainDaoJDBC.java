package aplication;

import java.sql.Connection;

import dataBase.DataBase;

public class MainDaoJDBC {

	public static void main(String[] args) {
		
		Connection connection = DataBase.getConnection();
		DataBase.closeConnection();

	}

}
