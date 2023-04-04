package com.example.filmyfilmy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioBookRepo extends CrudRepository<AudioBook, Long> {
}
