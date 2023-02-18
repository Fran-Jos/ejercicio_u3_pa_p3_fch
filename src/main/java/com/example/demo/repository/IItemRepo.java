package com.example.demo.repository;

import com.example.demo.modelo.Item;

public interface IItemRepo {

	public void insertar(Item item);
	
	public Item buscarPorCodigoDeBarras(String codBarra);
	
	public void actualizar(Item item);
	
	public Item buscarPorStockCriteria(Integer codigoBarras);

}
