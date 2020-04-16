package com.mindtree.librarieswebapp.service.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarieswebapp.entity.Library;
import com.mindtree.librarieswebapp.repository.LibraryRepository;
import com.mindtree.librarieswebapp.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	public void saveLibrary(Library library) {
		libraryRepository.save(library);
	}

	public List<Library> listAllLibrary() {
		return libraryRepository.findAll();
	}

	public Library getLibrary(long id) {
		return libraryRepository.findById(id).get();
	}

	public void updateLibrary(Library library, long id) {
		Library library2 = libraryRepository.findById(id).get();
		library2.setLibraryName(library.getLibraryName());

		libraryRepository.save(library2);
	}

	public void deleteLibrary(long id) {
		libraryRepository.deleteById(id);
	}

}
