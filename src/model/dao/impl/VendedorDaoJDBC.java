package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dataBase.DataBaseException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{
	
	private Connection connection;
	
	public VendedorDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void inserir(Vendedor departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Vendedor departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor buscarPorId(Integer id) {
		PreparedStatement prepStatment = null;
		ResultSet resultSet = null;
		try {
			prepStatment = connection.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			prepStatment.setInt(1, id);
			resultSet = prepStatment.executeQuery();
			if(resultSet.next()) {
				Departamento dep = new Departamento();
				dep.setId(resultSet.getInt("DepartmentId"));
				dep.setNome(resultSet.getString("DepName"));
				
				Vendedor vend = new Vendedor();
				vend.setId(resultSet.getInt("Id"));
				vend.setNome(resultSet.getString("Name"));
				vend.setEmail(resultSet.getString("Email"));
				vend.setNascimento(resultSet.getDate("BirthDate"));
				vend.setSalarioBase(resultSet.getDouble("BaseSalary"));
				vend.setDepartamento(dep);
				
				return vend;
			}
			return null;
		}
		catch (SQLException erro) {
			throw new DataBaseException(erro.getMessage());
		}
		
	}

	@Override
	public List<Vendedor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
