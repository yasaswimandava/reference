package com.mindtree.librarieswebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.librarieswebapp.dto.LoginDTO;
import com.mindtree.librarieswebapp.entity.Library;
import com.mindtree.librarieswebapp.service.LibraryService;

@Controller
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping(value = "/")
	public String loginPage(Model model) {
		model.addAttribute("loginobj", new LoginDTO());
		return "authenticationpage";
	}

	@RequestMapping(value = "verify")
	public String verifyLoginPage(@ModelAttribute("loginobj") LoginDTO loginDTO, Model model) {
		String email = "Naitik1998";
		String pswd = "naitik@123";
		if (loginDTO.getUsername().equalsIgnoreCase(email) && loginDTO.getPassword().equalsIgnoreCase(pswd)) {
			/*
			 * List<Library> listLibrary = libraryService.listAllLibrary();
			 * model.addAttribute("librarylist", listLibrary); return "index";
			 */
				return	homepage(model);
		}
		return "errorpage";

	}

	@RequestMapping(value = "indexpage", method = RequestMethod.GET)
	public String homepage(Model model) {
		List<Library> listLibrary = libraryService.listAllLibrary();

		model.addAttribute("librarylist", listLibrary);

		return "index";
	}

	@RequestMapping(value = "/addnewlibrary", method = RequestMethod.GET)
	public String addlibraryPage(Model model) {
		model.addAttribute("library", new Library());
		return "addlibrary";
	}

	@RequestMapping(value = "savelibrary", method = RequestMethod.POST)
	public String addLibrary(@ModelAttribute("library") Library library) {

		libraryService.saveLibrary(library);

		return "redirect:/indexpage";
	}

	@RequestMapping(value = "/editlibrary/{libraryId}", method = RequestMethod.GET)
	public String editLibraryPage(@PathVariable long libraryId, Model model) {
		model.addAttribute("library", libraryService.getLibrary(libraryId));
		return "updatelibrary";
	}

	@RequestMapping(value = "/editlibrary/{libraryId}/editlibsave", method = RequestMethod.POST)
	public String editLibrarySave(@ModelAttribute("library") Library library, @PathVariable long libraryId) {
		libraryService.updateLibrary(library, libraryId);
		return "redirect:/indexpage";
	}

	@RequestMapping(value = "/librarydelete", method = RequestMethod.GET)
	public String deleteLibraryPage(Model model) {
		List<Library> listLibrary = libraryService.listAllLibrary();

		model.addAttribute("librarylist", listLibrary);

		return "deletelibrary";
	}

	@RequestMapping(value = "/delete")
	public String deteleLibraryData(@RequestParam(name = "id") long id) {

		libraryService.deleteLibrary(id);

		return "redirect:/indexpage";

	}

}
