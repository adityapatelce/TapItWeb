package com.tapit.rider.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.tapit.rider.models.Rider;

@Transactional
@Repository
public class RiderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveRider(Rider rider) {
		entityManager.persist(rider);
	}
	
	@SuppressWarnings("unchecked")
	public List<Rider> getRidersFromEmail(String email){
		String hql = "FROM Rider as rider where rider.deleteFlag=0 AND rider.email = ?";
		return (List<Rider>) entityManager.createQuery(hql)
										  .setParameter(0, email)
										  .getResultList();
	}

}
