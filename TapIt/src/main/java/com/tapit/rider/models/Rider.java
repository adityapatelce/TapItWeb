package com.tapit.rider.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.tapit.models.User;

@Entity
@Table(name = "riders")
public class Rider extends User {

}
