package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dataBase.DataBase;
import dataBase.DataBaseException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao{
	
	private Connection connection = null;
	
	public DepartamentoDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void inserir(Departamento departamento) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("INSERT INTO department "
					+ "(Name) "
					+ "VALUES "
					+ "(?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, departamento.getNome());
			
			int linhasAfetadas = st.executeUpdate();
			if(linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					departamento.setId(id);
				}
				DataBase.closeResultSet(rs);
			}
			else {
				throw new DataBaseException("Erro inesperado ao inserir novo departamento");
			}
		}
		catch (SQLException erro) {
			throw new DataBaseException(erro.getMessage());
		}
		
	}

	@Override
	public void atualizar(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamento buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
