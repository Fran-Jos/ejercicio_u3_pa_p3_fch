package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Item;
import com.example.demo.service.IItemService;

@SpringBootApplication
public class EjercicioU3PaP3FcApplication implements CommandLineRunner {

	@Autowired
	private IItemService iItemService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP3FcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Item item = new Item();
		
		item.setCodigoDeBarras("aasss");
		item.setNombre("CocaCola");
		item.setPrecio(new BigDecimal(0.50));
		item.setStock(19);
		item.setTipo("Gaseosa");
		
		this.iItemService.insertar(item, 5)
		;
	}

}
