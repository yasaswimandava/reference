package com.mindtree.kalingacompany.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingacompany.dto.MovieTicketDTO;
import com.mindtree.kalingacompany.dto.ResponseBody;
import com.mindtree.kalingacompany.entity.MovieTicket;
import com.mindtree.kalingacompany.exception.KalingaCompanyAppException;
import com.mindtree.kalingacompany.service.MovieTicketService;

@RestController
public class MovieTicketController {

	@Autowired
	private MovieTicketService movieTicketService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/movieticket/{portalName}")
	public ResponseEntity<?> addMovieTicket(@Valid @RequestBody MovieTicketDTO movieTicket,
			@PathVariable String portalName) throws KalingaCompanyAppException {

		return new ResponseEntity<ResponseBody<MovieTicketDTO>>(
				new ResponseBody<MovieTicketDTO>(
						modelMapper.map(movieTicketService.addMovieTicketData(
								modelMapper.map(movieTicket, MovieTicket.class), portalName), MovieTicketDTO.class),
						null, "Movie ticket is booked Successfully", true),
				HttpStatus.OK);

	}

	@DeleteMapping("/movietickte/{movieName}")
	public ResponseEntity<?> deleteMovie(@PathVariable String movieName) throws KalingaCompanyAppException {
		movieTicketService.deleteMovieData(movieName);
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null, null, "Movie " + movieName + " is Deleted.", true), HttpStatus.OK);

	}

}
