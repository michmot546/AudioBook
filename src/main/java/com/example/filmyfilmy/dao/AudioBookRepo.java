package com.example.filmyfilmy.dao;

import com.example.filmyfilmy.dao.entity.AudioBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioBookRepo extends CrudRepository<AudioBook, Long> {
}
