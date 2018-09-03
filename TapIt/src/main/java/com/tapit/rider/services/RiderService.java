package com.tapit.rider.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tapit.rider.exceptions.RiderFoundException;
import com.tapit.rider.models.Rider;
import com.tapit.rider.repositories.RiderRepository;
import com.tapit.utils.Util;

@Service
public class RiderService {

	@Autowired
	private RiderRepository riderRepository;
	
	public Rider createRider(Map<String,Object> requestParam) {
		
		String email = Util.getStrValue(requestParam, "email");
		String phoneNumber  = Util.getStrValue(requestParam, "phoneNumber");
		
		Rider rider = new Rider();
		rider.setFirstName(Util.getStrValue(requestParam, "firstName"));
		rider.setLastName(Util.getStrValue(requestParam, "lastName"));
		rider.setPhoneNumber(phoneNumber);
		rider.setCreatedOn(Util.getUTCNow());
		rider.setUdpatedOn(Util.getUTCNow());
		rider.setEmail(email);
		rider.setTimeZone(Util.getStrValue(requestParam, "timeZone"));
		riderRepository.saveRider(rider);
		return rider;
	}
	
	public Rider signUpRider(Map<String,Object> requestParam) {
		
		String email = Util.getStrValue(requestParam, "email");
		List<Rider> riders = riderRepository.getRidersFromEmail(email);
		
		if(!riders.isEmpty())
			throw new RiderFoundException("Already exist account by given email :"+email);
		
		return createRider(requestParam);
	}
	
	public Rider loginByFacebook(Map<String,Object> requestParam) {
		
		String email = Util.getStrValue(requestParam, "email");
		List<Rider> riders = riderRepository.getRidersFromEmail(email);
		
		if(!riders.isEmpty())
			return riders.get(0);

		return createRider(requestParam);		

	}
	
}
