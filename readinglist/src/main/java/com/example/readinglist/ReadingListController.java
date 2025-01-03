package com.example.readinglist;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private static final Logger logger = LoggerFactory.getLogger(ReadingListController.class);
    private static final String reader = "craig";

    @Autowired
    private ReadingListRepository readingListRepository;

	@GetMapping
    public String readersBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }
  
	@PostMapping
    public String addToReadingList(Book book) {
		book.setReader(reader);
		logger.info("addToReadingList(): {}", book);
        readingListRepository.save(book);
        return "redirect:/";
    }

}
