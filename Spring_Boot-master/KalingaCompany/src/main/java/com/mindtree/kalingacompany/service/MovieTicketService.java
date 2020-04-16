package com.mindtree.kalingacompany.service;

import com.mindtree.kalingacompany.entity.MovieTicket;
import com.mindtree.kalingacompany.exception.service.KalingaCompanyAppServiceException;

public interface MovieTicketService {

	public MovieTicket addMovieTicketData(MovieTicket movieTicket, String portalName)
			throws KalingaCompanyAppServiceException;

	public void deleteMovieData(String movieName) throws KalingaCompanyAppServiceException;

}
