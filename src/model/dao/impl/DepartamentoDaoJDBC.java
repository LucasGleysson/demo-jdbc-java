package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement("UPDATE department "
					+ "SET Name = ?"
					+ "WHERE Id = ?", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, departamento.getNome());
			st.setInt(2, departamento.getId());
			st.executeUpdate();
		}
		catch(SQLException erro){
			throw new DataBaseException(erro.getMessage());
		}
		finally{
			DataBase.closeResultSet(rs);
			DataBase.closeStatement(st);
		}
		
	}

	@Override
	public void deletarPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement("DELETE FROM department "
											+ "WHERE Id = ?");
			
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(SQLException erro){
			throw new DataBaseException(erro.getMessage());
		}
		finally{
			DataBase.closeResultSet(rs);
			DataBase.closeStatement(st);
		}
		
	}

	@Override
	public Departamento buscarPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement("SELECT * FROM department "
											+ "WHERE department.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(rs.getInt("Id"));
				departamento.setNome(rs.getString("Name"));
				return departamento;
			}
			return null;
		}
		catch(SQLException erro) {
			throw new DataBaseException(erro.getMessage());
		}
	}

	@Override
	public List<Departamento> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement("SELECT * FROM department");
			
			
			rs = st.executeQuery();
			
			List<Departamento> lista = new ArrayList<>();
			while(rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(rs.getInt("Id"));
				departamento.setNome(rs.getString("Name"));
				lista.add(departamento);	
			}
			return lista;
			
		}
		catch(SQLException erro) {
			throw new DataBaseException(erro.getMessage());
		}
	}

}
