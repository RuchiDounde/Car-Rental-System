package com.app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dao.CustomerDao;
import com.dao.EngineDao;

public class AccessCustomerData {
public static void main(String[] args) {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		System.out.println("Enter your options");
		System.out.println("Press 1 for Add the customer");
		System.out.println("Press 2 for delete the customer");
		System.out.println("Press 3 for find customer Id");
		System.out.println("Press 4 for get customer car booking details");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:CustomerDao.addCustomer();
		break;
		case 2:CustomerDao.deleteCustomer(2);
		break;
		case 3:CustomerDao.findById();
		break;
		case 4:CustomerDao.customerBookingDetails(11);
		break;
		default:System.out.println("Enter valid number");
		break;
}
}
}