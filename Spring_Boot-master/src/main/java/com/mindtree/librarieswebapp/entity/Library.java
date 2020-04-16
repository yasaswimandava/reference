package com.mindtree.librarieswebapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "libraryId")
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long libraryId;

	private String libraryName;

	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	private List<Book> booksList;

	public Library() {
		// TODO Auto-generated constructor stub
	}

	public Library(String libraryName, List<Book> booksList) {
		this.libraryName = libraryName;
		this.booksList = booksList;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Book> booksList) {
		this.booksList = booksList;
	}

	public long getLibraryId() {
		return libraryId;
	}
	
	

}
