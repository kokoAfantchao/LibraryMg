package com.cs841.librarymanagementsystem;

import com.cs841.librarymanagementsystem.entity.Author;
import com.cs841.librarymanagementsystem.entity.Category;
import com.cs841.librarymanagementsystem.service.AuthorService;
import com.cs841.librarymanagementsystem.service.BookService;
import com.cs841.librarymanagementsystem.service.CategoryService;
import com.cs841.librarymanagementsystem.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.cs841.librarymanagementsystem.entity.Book;
import com.cs841.librarymanagementsystem.entity.Publisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LibrarymanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementsystemApplication.class, args);
	}


	@Bean
	@Profile(value = "dev")
	public CommandLineRunner initialCreate(BookService bookServic, PublisherService publisherService,
										   BookService bookService, CategoryService categoryServic,
										   AuthorService authorService) {
		return (args) -> {

			Book book = new Book("Test isbn", "Test name", "Test serial name", "Test description");
			Author author = new Author("Test author name", "Test description");
			Category category = new Category("Test category name");
			Publisher publisher = new Publisher("Test publisher name");

			book.addAuthors(author);
			book.addCategories(category);
			book.addPublishers(publisher);

			bookService.createBook(book);

			Book book1 = new Book("Test isbn1", "Test name1", "Test serial name1", "Test description1");
			Author author1 = new Author("Test author name1", "Test description1");
			Category category1 = new Category("Test category name1");
			Publisher publisher1 = new Publisher("Test publisher name1");

			book1.addAuthors(author1);
			book1.addCategories(category1);
			book1.addPublishers(publisher1);

			bookService.createBook(book1);

			Book book2 = new Book("Test isbn2", "Test name2", "Test serial name2", "Test description2");
			Author author2 = new Author("Test author name2", "Test description2");
			Category category2 = new Category("Test category name2");
			Publisher publisher2 = new Publisher("Test publisher name2");

			book2.addAuthors(author2);
			book2.addCategories(category2);
			book2.addPublishers(publisher2);

			bookService.createBook(book2);

		};
	}
}
