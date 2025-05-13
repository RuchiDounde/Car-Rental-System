package com.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Customer;
import com.util.DbConnection;

public class CustomerDao {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
//	Customer r = new Customer();
//	r.setName("Sarvesh");
//	r.setLocation("Baramati");
//	r.setRegisterDate(LocalDate.of(2025, 6, 10));
//	r.setReturnDate(LocalDate.of(2025,6, 20));
//	
//	Car c = new Car();
//	c.setBrand("Maruti");
//	c.setModel("Suzuki");
//	c.setRegisterDate(LocalDate.of(2025, 2, 19));
//	
//	r.setCar(c);
//	
//	
//	et.begin();
//	em.persist(r);
//	em.persist(c);
//	et.commit();
	
	//deleteCustomer(6) ;
	//addCustomer();
	//findById();
	customerBookingDetails(11);
}
public static void addCustomer() {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	Customer r = new Customer();
	r.setName("Samuu");
	r.setLocation("Sangli");
	r.setRegisterDate(LocalDate.of(2024, 9, 10));
	r.setReturnDate(LocalDate.of(2025,9, 20));
	et.begin();
	em.persist(r);
	et.commit();
}

public static void deleteCustomer(int id) {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	String jpql = "delete from Customer c where c.id=?2";
	Query query = em.createQuery(jpql);
	query.setParameter(2 ,id );
	int count = query.executeUpdate();
	System.out.println(count);
	et.commit();
}
public static void findById() {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	String jpql = "Select r from Customer r where r.id=?5";
	et.begin();
	Query query = em.createQuery(jpql);
	query.setParameter(5, 11);
	List<Customer> li = query.getResultList();
	li.forEach(al->System.out.println(al.getLocation()+" " +al.getName()+" "));
	et.commit();
}
public static void customerBookingDetails(int customer_id) {
	EntityManager em = DbConnection.getEntityManager();
	EntityTransaction et = em.getTransaction();
	Customer r = em.find(Customer.class, customer_id );
	Car car = r.getCar();
	System.out.println("Customer name: "+ r.getName());
	System.out.println("Customer location: "+ r.getLocation());
	System.out.println("register date: "+ r.getRegisterDate());
	System.out.println("return date: "+ r.getReturnDate());
	
}

}
