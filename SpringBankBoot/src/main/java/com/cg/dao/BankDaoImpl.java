package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.model.CustomerDetails;

@Repository
@Component("bankDao")
public class BankDaoImpl implements BankDao {

	@PersistenceContext
	EntityManager entityManager;
	public CustomerDetails register(CustomerDetails cd) {
		// TODO Auto-generated method stub
		entityManager.persist(cd);
		entityManager.flush();
		return cd;
	}
	public CustomerDetails login(CustomerDetails c) {
		// TODO Auto-generated method stub
		CustomerDetails cd = entityManager.find(CustomerDetails.class, c.getAccountNo());
		if(cd.getPassword().equals(c.getPassword())) {
			return cd;
		}
		else
			return null;
	}
}
