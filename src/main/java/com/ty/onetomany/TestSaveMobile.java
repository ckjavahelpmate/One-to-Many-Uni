package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobile {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Sim sim1 = new Sim() ;
		sim1.setProvider("Jio");
		sim1.setType("4g");
		Sim sim2 = new Sim() ;
		sim2.setProvider("Artel");
		sim2.setType("3g");
		Sim sim3 = new Sim() ;
		sim3.setProvider("BSNL");
		sim3.setType("5g");
		
		List<Sim> sims = new ArrayList<Sim>() ;
		sims.add(sim3) ;
		sims.add(sim1) ;
		
		
		Mobile mobile = new Mobile() ;
		mobile.setName("OPPO");
		mobile.setCost(18000.0);
		mobile.setSims(sims);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
	//	entityManager.persist(sim3);
	//	entityManager.persist(sim1);
		entityTransaction.commit();

	}

}
