package com.ty.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		BankAccount account1 = new BankAccount() ;
		account1.setAcno(123);
		account1.setName("ck");
		account1.setBal(5000);
		
		BankAccount account2 = new BankAccount() ;
		account2.setAcno(456);
		account2.setName("ck");
		account2.setBal(10000);
		
		BankAccount account3 = new BankAccount() ;
		account3.setAcno(789);
		account3.setName("ck");
		account3.setBal(20000);
		
		List<BankAccount> accounts = new ArrayList() ;
		accounts.add(account1) ;
		accounts.add(account2) ;
		accounts.add(account3) ;

		Person person = new Person() ;
		person.setName("ck");
		person.setEmail("ck@mail.com");
		person.setAccount(accounts);
		
		entityTransaction.begin();
		 
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);
		entityManager.persist(person);
		
		entityTransaction.commit();
		
		
		
	}

}
