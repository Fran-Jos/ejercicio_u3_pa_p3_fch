package com.example.demo.repository;

import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ItemRepoImpl implements IItemRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Item item) {
		// TODO Auto-generated method stub
		this.entityManager.persist(item);
		
	}

	@Override
	public Item buscarPorCodigoDeBarras(String codBarra) {
		// TODO Auto-generated method stub
		
	TypedQuery< Item> query = this.entityManager.createNamedQuery("buscarPorCodigoDeBarras", Item.class);
	query.setParameter("datoCB", codBarra);
	
		return query.getSingleResult();
	}

	@Override
	public void actualizar(Item item) {
		// TODO Auto-generated method stub
		
		this.entityManager.merge(item);
		
		
	}
	
	public Item buscarPorStockCriteria(Integer codigoBarras) {
		
			
				CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

			
				CriteriaQuery<Item> myCriteriaQuery = myBuilder.createQuery(Item.class);

	
			    Root<Item> miTablaFrom = myCriteriaQuery.from(Item.class); 

				Predicate condicion1 =  (Predicate) myBuilder.equal(miTablaFrom.get("codigoBarras"), codigoBarras);

			
				myCriteriaQuery.select(miTablaFrom).where((Expression<Boolean>) condicion1);

	

			TypedQuery<Item> mySQL = this.entityManager.createQuery(myCriteriaQuery);

			return mySQL.getSingleResult();
			

			
				
			}

}
