package com.mindtree.kalingacompany.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "movieTicketId")

public class MovieTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Movie_Ticket_Id")
	private long movieTicketId;

	@Column(name = "Movie_Name")
	private String movieName;

	@Column(name = "Movie_Ticket_Price")
	private double ticketPrice;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnore
	private BookingPortal bookingPortal;

	public MovieTicket() {
		// TODO Auto-generated constructor stub
	}

	public MovieTicket(String movieName, double ticketPrice, BookingPortal bookingPortal) {
		this.movieName = movieName;
		this.ticketPrice = ticketPrice;
		this.bookingPortal = bookingPortal;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public BookingPortal getBookingPortal() {
		return bookingPortal;
	}

	public void setBookingPortal(BookingPortal bookingPortal) {
		this.bookingPortal = bookingPortal;
	}

	public long getMovieTicketId() {
		return movieTicketId;
	}

}
