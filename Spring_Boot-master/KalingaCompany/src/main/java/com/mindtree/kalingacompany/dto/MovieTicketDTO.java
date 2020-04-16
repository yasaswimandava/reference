package com.mindtree.kalingacompany.dto;

import javax.validation.constraints.NotNull;

import com.mindtree.kalingacompany.entity.BookingPortal;

public class MovieTicketDTO {

	private long movieTicketId;

	@NotNull(message = "Store Name Cannot Be Empty")
	private String movieName;
	
	@NotNull(message =" Movie Ticket Price Cannot Be Empty")
	private double ticketPrice;

	private BookingPortal bookingPortal;

	public MovieTicketDTO() {
		// TODO Auto-generated constructor stub
	}

	public MovieTicketDTO(long movieTicketId, String movieName, double ticketPrice, BookingPortal bookingPortal) {
		this.movieTicketId = movieTicketId;
		this.movieName = movieName;
		this.ticketPrice = ticketPrice;
		this.bookingPortal = bookingPortal;
	}

	public long getMovieTicketId() {
		return movieTicketId;
	}

	public void setMovieTicketId(long movieTicketId) {
		this.movieTicketId = movieTicketId;
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
	
	
}
