package fi.haagahelia.course.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Book;



@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 
	
	@Autowired
	private CategoryRepository crepository; 
	
	
    @RequestMapping(value= {"/", "/booklist"})
    public String bookList(Model model) {
    	System.out.println("hei");
    	
        model.addAttribute("books", repository.findAll());
        return "booklist";       
    }
    
    //REST
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
    return (List<Book>) repository.findAll();
    }
    
    //REST
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    } 
    
    
    
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	 System.out.println("moi");
    	
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
    	
    	
    	
        return "addbook";
    }     
    
    @RequestMapping(value = "/edit/{id}", method= RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	System.out.println("terve");
    	
    	model.addAttribute("book" , repository.findById(bookId));
    	model.addAttribute("categories", crepository.findAll());
    	
    	
        return "editbook";
    }   
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
    	System.out.println("moro");
    	
    	repository.save(book);
           
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
   	 	System.out.println("tere");
    	
    	repository.deleteById(bookId);
    	
        return "redirect:../booklist";
    }     
}
