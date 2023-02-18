package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Item;
import com.example.demo.repository.IItemRepo;

@Service
public class ItemSerivceImpl implements IItemService {

	@Autowired
	private IItemRepo  iItemRepo;
	
	
	@Override
	public void insertar(Item item, Integer stock) {
		// TODO Auto-generated method stub
	// primero valido si existe el item  por cod de barras
		
		Item myItem = this.iItemRepo.buscarPorCodigoDeBarras(item.getCodigoDeBarras());
		
		if(myItem != null){
			
			Integer StockNuevo = myItem.getStock() + stock;
			
			
			myItem.setStock(StockNuevo);
			
			this.iItemRepo.actualizar(myItem);
			
			this.iItemRepo.insertar(myItem);
			
			
		}else {
			System.out.println("EL producto no existia: ");
			
			this.iItemRepo.insertar(myItem);
		}
		
	}


	@Override
	public void actualizar(Item item) {
		// TODO Auto-generated method stub
		
		this.iItemRepo.actualizar(item);
		
	}

}
