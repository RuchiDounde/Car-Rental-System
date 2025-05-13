package com.app;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dao.CarDao;

public class AccessCarData {
public static void main(String[] args) {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		System.out.println("Enter your options");
		System.out.println("Press 1 for find the date");
		System.out.println("Press 2 for allocate the engine");
		System.out.println("Press 3 for update the engine id");
		System.out.println("Press 4 for deallocate the engine");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:CarDao.findByDate(LocalDate.of(2025, 8, 10));
			break;
		case 2:CarDao.allocateEngine(100,1);
		break;
		case 3:CarDao.updateEngineId();
		break;
		case 4 :CarDao.deallocateEngine();
		break;
       default:System.out.println("Please enter valid numbar");
			break;
		}
}
}
