package com.abdulrahman.final_Project.Feedback;

import com.abdulrahman.final_Project.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    final private FeedbackRepo feedbackRepo;

    public List<Feedback> getBooks(){
        return feedbackRepo.findAll();
    }
    public void addBook(Feedback feedback){
        feedbackRepo.save(feedback);

    }
    public void editBook(Integer id, Feedback feedback){
        Feedback temp = feedbackRepo.findBookById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        temp.setBookCount(feedback.getBookCount());
        temp.setName(feedback.getName());

        feedbackRepo.save(temp);

    }
    public void deleteBook(Integer id){
        Feedback temp = feedbackRepo.findBookById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        feedbackRepo.delete(temp);

    }

//    public Integer returnCount(Integer id){
//        Feedback temp = feedbackRepo.findBookById(id);
//        if (temp == null) {
//            throw new ApiException("Not found");
//        }
//        return temp.getBookCount();
//
//    }
//    public Feedback returnBookInfoByName(String name){
//        Feedback temp = feedbackRepo.findBookByName(name);
//        if (temp == null) {
//            throw new ApiException("Not found");
//        }
//        return temp;
//
//    }
//    public List<Feedback> findByGenre(String genre){
//        List<Feedback> feedbacks = feedbackRepo.findAllByGenre(genre);
//        if (feedbacks.isEmpty()) {
//            throw new ApiException("Not found");
//        }
//        return feedbacks;
//
//    }
}
