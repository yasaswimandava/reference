package com.mindtree.kalingacompany.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "porttalId")
public class BookingPortal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Portal_Id")
	private long porttalId;

	@Column(name = "Portal_Name")
	private String portalName;

	@OneToMany(mappedBy = "bookingPortal", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("bookingPortal")
	private List<MovieTicket> movieTicket;

	public BookingPortal() {
		// TODO Auto-generated constructor stub
	}

	public BookingPortal(String portalName, List<MovieTicket> movieTicket) {
		this.portalName = portalName;
		this.movieTicket = movieTicket;
	}

	public String getPortalName() {
		return portalName;
	}

	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}

	public List<MovieTicket> getMovieTicket() {
		return movieTicket;
	}

	public void setMovieTicket(List<MovieTicket> movieTicket) {
		this.movieTicket = movieTicket;
	}

	public long getPorttalId() {
		return porttalId;
	}

}
