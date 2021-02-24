package dataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBase {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				Properties propriedades = carregarProperties();
				String url = propriedades.getProperty("dburl");
				connection = DriverManager.getConnection(url, propriedades);
			}
			catch(SQLException erro) {
				throw new DataBaseException(erro.getMessage());
			}
		}
		return connection;
	}
	
	
	
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			}
			catch(SQLException erro) {
				throw new DataBaseException(erro.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch(SQLException erro) {
				throw new DataBaseException(erro.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}
			catch(SQLException erro) {
				throw new DataBaseException(erro.getMessage());
			}
		}
	}
	
	
	
	
	public static Properties carregarProperties() {
		try(FileInputStream fileStream = new FileInputStream("db.properties")){
			Properties propriedades = new Properties();
			propriedades.load(fileStream);
			return propriedades;
		}
		catch(IOException erro) {
			throw new DataBaseException(erro.getMessage());
		}
	}
}
