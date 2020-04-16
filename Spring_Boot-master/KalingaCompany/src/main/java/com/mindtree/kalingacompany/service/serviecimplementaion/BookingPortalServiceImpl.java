package com.mindtree.kalingacompany.service.serviecimplementaion;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingacompany.entity.BookingPortal;
import com.mindtree.kalingacompany.entity.MovieTicket;
import com.mindtree.kalingacompany.exception.service.KalingaCompanyAppServiceException;
import com.mindtree.kalingacompany.exception.service.custom.BookingPortalIsAlreadyExistsException;
import com.mindtree.kalingacompany.exception.service.custom.BookingPortalIsNotExistsException;
import com.mindtree.kalingacompany.exception.service.custom.BookingPorttalNotFoundException;
import com.mindtree.kalingacompany.exception.service.custom.NoMovieTicketIsBookedException;
import com.mindtree.kalingacompany.repository.BookingPortalRepository;
import com.mindtree.kalingacompany.repository.MovieTicketRepository;
import com.mindtree.kalingacompany.service.BookingPortalService;

@Service
public class BookingPortalServiceImpl implements BookingPortalService {

	@Autowired
	private BookingPortalRepository bookingPortalRepository;

	@Autowired
	private MovieTicketRepository movieTicketRepository;

	@Override
	public BookingPortal addBookingPortalData(BookingPortal bookingPortal) throws KalingaCompanyAppServiceException {

		if (bookingPortalRepository.findByPortalName(bookingPortal.getPortalName()).isPresent())
			throw new BookingPortalIsAlreadyExistsException("Booking Portal Is Already Exists. ");

		bookingPortalRepository.save(bookingPortal);
		return bookingPortal;

	}

	@Override
	public List<BookingPortal> getBookingPortalData() throws KalingaCompanyAppServiceException {
		// List<BookingPortal> bookingPortalList = null;
		List<BookingPortal> bookingPortalList = bookingPortalRepository.findAll();

		if (bookingPortalList.isEmpty())
			throw new BookingPorttalNotFoundException("Booking portal is empty");

		bookingPortalList.forEach(bookingPortal1 -> {
			List<MovieTicket> movieTicketList = bookingPortal1.getMovieTicket();

			Collections.sort(movieTicketList, new Comparator<MovieTicket>() {
				public int compare(MovieTicket m1, MovieTicket m2) {
					return -Double.compare(m1.getTicketPrice(), m2.getTicketPrice());
				}
			});
		});

		return bookingPortalList;

	}

	@Override
	public void deleteBookingPorttalData(String portalName) throws KalingaCompanyAppServiceException {
		BookingPortal bookingPortal = bookingPortalRepository.findByPortalName(portalName)
				.orElseThrow(() -> new BookingPortalIsNotExistsException("Booking Portal Is Not Exists. "));

		List<MovieTicket> movieTicketList = bookingPortal.getMovieTicket();

		if (movieTicketList.isEmpty())
			throw new NoMovieTicketIsBookedException("No Movie ticket is booked.");

		for (MovieTicket movieTicket : movieTicketList) {
			movieTicket.setBookingPortal(null);
		}

		movieTicketRepository.saveAll(movieTicketList);
		bookingPortalRepository.delete(bookingPortal);

	}

	/*
	 * public Map<String, String> displayMovieTicketWithPortal() {
	 * 
	 * List<MovieTicket> movieTickets = movieTicketRepository.findAll(); Map<,
	 * String> map = new TreeMap<MovieTicket, String>(); for (MovieTicket
	 * movieTicket : movieTickets) { MovieTicket movieTicket2 = new m String
	 * bookingPortalName = movieTicket.getBookingPortal().getPortalName();
	 * 
	 * map.put(movieTicket, bookingPortalName); }
	 * 
	 * return null;
	 * 
	 * }
	 */

}
