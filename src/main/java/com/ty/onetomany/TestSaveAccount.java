package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Page page1 = new Page() ;
		page1.setName("chathan");
		page1.setTitle("Ck-boys");
		page1.setDescription("Group of Ck friends");
		Page page2 = new Page() ;
		page2.setName("chethan");
		page2.setTitle("Ck-works");
		page2.setDescription("project work of ck");
		Page page3 = new Page() ;
		page3.setName("chathan");
		page3.setTitle("Ck-java-notes");
		page3.setDescription("java notes from Ck");
		
		List<Page> pages = new ArrayList() ;
		pages.add(page1) ;
		pages.add(page2) ;
		pages.add(page3) ;
		
		UserAccount account = new UserAccount() ;
		account.setName("chathan");
		account.setEmail("chathan@gmail.com");
		account.setMobile(786458978);
		account.setPassword("chathan@123");
		account.setPage(pages);
		
		entityTransaction.begin();
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityManager.persist(page3);
		entityManager.persist(account);
		entityTransaction.commit();

		

	}

}
