package com.ty.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobile {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;

		Mobile mobile = entityManager.find( Mobile.class, 4 ) ;
		if(mobile!=null) {
			System.out.println("Mobile Name: "+ mobile.getName() );
			System.out.println("Mobile cost: "+ mobile.getCost() );

			List<Sim> sims = mobile.getSims() ;
			for(Sim sim : sims) {
				System.out.println("*****************************************");
				System.out.println( "Sim ID: "+sim.getId());
				System.out.println( "Sim Provider: "+sim.getProvider());
				System.out.println( "Sim Type: "+sim.getType());
				System.out.println("*****************************************");
			}
		}
		else {
			System.out.println("No mobile found");
		}






	}

}
