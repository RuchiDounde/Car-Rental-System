package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jboss.jandex.Main;

import com.entity.Car;
import com.entity.Engine;
import com.util.DbConnection;

public class EngineDao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
	Engine e = new Engine();
		e.setType("Petrol");
		e.setCc(3500);
		et.begin();
		em.persist(e);
		et.commit();
	//	c.setEngine(e);
		//deleteByEngine(6);
		//findAllEngine();
	}
	
	 public static void deleteByEngine( int id) {
		 EntityManager em = DbConnection.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			String jpql = "delete from Engine e where e.id=?1";
			Query query = em.createQuery(jpql);
			query.setParameter(1,id );
			int count = query.executeUpdate();
			System.out.println(count);
			et.commit();
	 }   
	 public static void findAllEngine() {
		 EntityManager em = DbConnection.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			String jpql = "Select e from Engine e ";
			Query query = em.createQuery(jpql);
			List<Engine> li = query.getResultList();
			li.forEach(al->System.out.println(al.getType()+ " " + al.getCc()+ " "));
			et.commit();
	 }
	
}
