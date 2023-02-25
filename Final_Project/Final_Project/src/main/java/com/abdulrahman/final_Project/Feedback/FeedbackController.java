package com.abdulrahman.final_Project.Feedback;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class FeedbackController {

    // ServiceInjection
    private final FeedbackService feedbackService;

    // getter
    @GetMapping("/get_feedback")
    public List<Feedback> getBooks(){
        return feedbackService.getBooks();
    }
    @PostMapping("/add_feedback")

    public ResponseEntity addBooks( @RequestBody Feedback feedback){
                feedbackService.addBook(feedback);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/edit_feedback")
    public ResponseEntity updateBooks(@PathVariable Integer id, @RequestBody Feedback feedback){
        feedbackService.editBook(id, feedback);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/delete_feedback")
    public ResponseEntity updateBooks(@PathVariable Integer id){
        feedbackService.deleteBook(id);
        return ResponseEntity.status(200).body("Updated");

    }

    // Create endpoint that takes a _feedback name and return all _feedback information
//    @GetMapping("/get__feedback_info/{name}")
//    public ResponseEntity updateBooks(@PathVariable String name){
//       Feedback feedback = feedbackService.returnBookInfoByName(name);
//        return ResponseEntity.status(200).body(feedback);
//
//    }
//    // Create endpoint that takes _feedbackId and return number of _feedbacks available
//    @GetMapping("/get__feedback_count/{id}")
//    public ResponseEntity getBooksCount(@PathVariable Integer id){
//        Integer _feedback_count = feedbackService.returnCount(id);
//        return ResponseEntity.status(200).body(_feedback_count);
//
//    }
//    // Create endpoint that return all _feedbacks under a specific genre
//    @GetMapping("/get__feedback_by_genre/{genre}")
//    public ResponseEntity getBooksByGenre(@PathVariable String genre){
//        List<Feedback> feedbacks = feedbackService.findByGenre(genre);
//        return ResponseEntity.status(200).body(feedbacks);
//
//    }
}
