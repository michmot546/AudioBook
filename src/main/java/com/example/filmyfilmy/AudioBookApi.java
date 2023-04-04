package com.example.filmyfilmy;

import com.example.filmyfilmy.AudioBook;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AudioBookApi {
    private List<AudioBook> audioBooks;

    public AudioBookApi() {
        audioBooks = new ArrayList<>();
        AudioBook book1 = new AudioBook();
        book1.setId(1L);
        book1.setTitle("The List");
        book1.setAuthor("Puma Rubber");
        book1.setProductionYear(LocalDate.of(1979, 10, 12));
        audioBooks.add(book1);

        AudioBook book2 = new AudioBook();
        book2.setId(2L);
        book2.setTitle("Harry Potter and Twitter drama");
        book2.setAuthor("J.K. Rowling");
        book2.setProductionYear(LocalDate.of(1997, 6, 26));
        audioBooks.add(book2);
    }

    @GetMapping("/audioBooks")
    public List<AudioBook> getAudioBooks() {
        return audioBooks;
    }

    @GetMapping("/audioBooks/{id}")
    public Optional<AudioBook> getAudioBookById(@PathVariable Long id) {
        return audioBooks.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @PostMapping
    public boolean addBook(@RequestBody AudioBook audioBook) {
        return audioBooks.add(audioBook);
    }

    @PutMapping("/{id}")
    public boolean modifyBook(@PathVariable("id") Long id, @RequestBody AudioBook audioBook) {
        Optional<AudioBook> optionalAudioBook = getAudioBookById(id);
        if (optionalAudioBook.isPresent()) {
            AudioBook oldAudioBook = optionalAudioBook.get();
            oldAudioBook.setTitle(audioBook.getTitle());
            oldAudioBook.setAuthor(audioBook.getAuthor());
            return true;
        } else {
            return false;
        }
    }
    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable("id") int id) {
        return audioBooks.removeIf(audioBook -> audioBook.getId() == id);
    }
}