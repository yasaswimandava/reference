package com.mindtree.librarieswebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarieswebapp.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
