package com.tapit.rider.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tapit.models.User;
import com.tapit.rider.models.Rider;
import com.tapit.rider.services.RiderService;
import com.tapit.utils.Util;

@RestController
@RequestMapping("/rider")
public class RiderController {

	@Autowired
	private RiderService riderService;
	
	
	@PostMapping(value="/login")
	public ResponseEntity<Rider> loginRider(@RequestParam Map<String,Object> requestParam) {
		Rider rider = null;
		if(requestParam.containsKey("facebookLogin")) {
			rider = riderService.loginByFacebook(requestParam);
		}		
		
		return new ResponseEntity<Rider>(rider,HttpStatus.OK);
	}
	
	
	@PostMapping(value="/create")
	public ResponseEntity<Rider> createRider(@RequestParam Map<String,Object> requestParam) {		
		Rider rider = riderService.signUpRider(requestParam);		
		return new ResponseEntity<Rider>(rider,HttpStatus.OK);
	}	

}
