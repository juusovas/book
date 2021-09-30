package fi.haagahelia.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String author;
    private String isbn;
    private String title;
    private String year;
   
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    
    public Book() {}

	public Book(String author, String isbn, String title, String year, Category category) {
		super();
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", author=" + author + ", isbn=" + isbn + ", title=" + title + ", year=" + year + " category =" + this.getCategory() + "]";
		
		else		
			return "Book [id=" + id + ", author=" + author + ", isbn=" + isbn + ", title=" + title + ", year=" + year + "]";
	}

	
	
}
