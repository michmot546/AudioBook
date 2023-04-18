package com.example.filmyfilmy.manager;

import com.example.filmyfilmy.dao.AudioBookRepo;
import com.example.filmyfilmy.dao.entity.AudioBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AudioBookManager {

    private final AudioBookRepo audioBookRepo;

    @Autowired
    public AudioBookManager(AudioBookRepo audioBookRepo) {
        this.audioBookRepo = audioBookRepo;
    }

    public Optional<AudioBook> findById(Long id) {
        return audioBookRepo.findById(id);
    }

    public Iterable<AudioBook> findAll() {
        return audioBookRepo.findAll();
    }

    public AudioBook save(AudioBook audioBook) {
        return audioBookRepo.save(audioBook);
    }

    public void deleteById(Long id) {
        audioBookRepo.deleteById(id);
    }
}