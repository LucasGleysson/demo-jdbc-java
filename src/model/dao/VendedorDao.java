package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Vendedor;

public interface VendedorDao {

	void inserir(Vendedor departamento);
	void atualizar(Vendedor departamento);
	void deletarPorId(Integer id);
	Vendedor buscarPorId(Integer id);
	List<Vendedor> buscarTodos();
	List<Vendedor> buscarPorDepartamento(Departamento departamento);
}
