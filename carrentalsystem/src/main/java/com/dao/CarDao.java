package com.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Engine;
import com.util.DbConnection;

public class CarDao {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
  Car c = new Car();
	c.setBrand("BMW");
	c.setModel("Honda");
	c.setRegisterDate(LocalDate.of(2023, 3, 15));
	
	Engine e = new Engine();
	e.setType("Petrol");
	e.setCc(3400);
	c.setEngine(e);
	et.begin();
	em.persist(c);
	em.persist(e);
	et.commit();
	
	
	
	//findByDate(LocalDate.of(2025, 8, 10));
	//allocateEngine(102,3);
	//updateEngineId();
	//deallocateEngine();
	
	
}


public static void findByDate(LocalDate date) {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	
	String jpql = "Select c from Car c where c.registerDate=?1";
	Query query = em.createQuery(jpql);
	query.setParameter(1, date);
	List<Car> li = query.getResultList();
	li.forEach(al->System.out.println(al.getId()+" " + al.getBrand()+" "+ al.getModel()));
}
public static void allocateEngine(int car_id, int engine_id) {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	 String sql = "Update car set engine_id=:e_id where id=:c_id";
	 et.begin();
	 Query query = em.createNativeQuery(sql,Car.class);
	 query.setParameter("e_id", engine_id);
	 query.setParameter("c_id", car_id);
	 int count = query.executeUpdate();
	 System.out.println(count);
	 et.commit();
}
public static void updateEngineId() {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	Car car = em.find(Car.class, 100);
	car.setEngine(null);
	em.merge(car);
	et.commit();
}
public static void deallocateEngine() {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	Car car = em.find(Car.class, 101);
	car.setEngine(null);
	em.merge(car);
	et.commit();
}
}
