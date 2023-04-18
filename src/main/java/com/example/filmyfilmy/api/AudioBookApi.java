package com.example.filmyfilmy.api;

import com.example.filmyfilmy.dao.AudioBookRepo;
import com.example.filmyfilmy.dao.entity.AudioBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audioBooks")
public class AudioBookApi {

    @Autowired
    private AudioBookRepo audioBookRepository;

    @GetMapping("/")
    public Iterable<AudioBook> getAudioBooks() {
        return audioBookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AudioBook> getAudioBookById(@PathVariable Long id) {
        return audioBookRepository.findById(id);
    }

    @PostMapping("/")
    public AudioBook addBook(@RequestBody AudioBook audioBook) {
        return audioBookRepository.save(audioBook);
    }

    @PutMapping("/{id}")
    public boolean modifyBook(@PathVariable("id") Long id, @RequestBody AudioBook audioBook) {
        Optional<AudioBook> optionalAudioBook = audioBookRepository.findById(id);
        if (optionalAudioBook.isPresent()) {
            AudioBook oldAudioBook = optionalAudioBook.get();
            oldAudioBook.setTitle(audioBook.getTitle());
            oldAudioBook.setAuthor(audioBook.getAuthor());
            audioBookRepository.save(oldAudioBook);
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable("id") Long id) {
        try {
            audioBookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}