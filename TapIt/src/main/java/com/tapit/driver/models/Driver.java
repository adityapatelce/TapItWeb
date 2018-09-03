package com.tapit.driver.models;

import javax.persistence.*;

import com.tapit.models.User;

@Entity
@Table(name = "drivers")
public class Driver extends User{
	
	@Column(name ="available",length =1)
	private byte available ;
}
