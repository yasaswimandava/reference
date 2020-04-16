package com.mindtree.librarieswebapp.service;

import java.util.List;

import com.mindtree.librarieswebapp.entity.Library;

public interface LibraryService {

	public void saveLibrary(Library library);

	public List<Library> listAllLibrary();

	public Library getLibrary(long id);

	public void updateLibrary(Library library, long id);

	public void deleteLibrary(long id);

}
