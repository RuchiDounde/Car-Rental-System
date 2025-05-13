package com.app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dao.EngineDao;

public class AccessEngineData {
	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			System.out.println("Enter your options");
			System.out.println("Press 1 for delete the id");
			System.out.println("Press 2 for find all engine");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			case 1:EngineDao.deleteByEngine(3);
			break;
			case 2:EngineDao.findAllEngine();
			break;
			default:System.out.println("Enter valid number");
				break;
			}
	}
	
}
