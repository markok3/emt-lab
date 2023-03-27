package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.models.Country;
import com.example.demo.repo.AuthorRepository;
import com.example.demo.repo.BookRepository;
import com.example.demo.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class TestDataGenerator {


    private static final Random rand = new Random();
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public TestDataGenerator(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    public void generateTestData() {
        List<Country> countries = generateCountries(5);
        countryRepository.saveAll(countries);
        List<Author> authors = generateAuthors(5);
        authorRepository.saveAll(authors);

        List<Book> books = generateBooks(10, authors);
        bookRepository.saveAll(books);
    }

    private List<Author> generateAuthors(int numAuthors) {
        List<String> names = Arrays.asList("John", "Emily", "William", "Olivia", "Jacob", "Sophia", "Michael", "Isabella");
        List<String> surnames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia");
        List<Country> countries = countryRepository.findAll();
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < numAuthors; i++) {
            Author author = new Author();
            author.setName(names.get(rand.nextInt(names.size())));
            author.setSurname(surnames.get(rand.nextInt(surnames.size())));
            author.setCountry(countries.get(rand.nextInt(countries.size())));
            authors.add(author);
        }
        return authors;
    }

    private List<Country> generateCountries(int numCountries) {
        List<String> names = Arrays.asList("United States", "China", "Japan", "Germany", "India", "Russia", "France", "Brazil", "Canada");
        List<String> continents = Arrays.asList("North America", "Asia", "Asia", "Europe", "Asia", "Europe", "Europe", "South America", "North America");
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < numCountries; i++) {
            Country country = new Country();
            country.setName(names.get(rand.nextInt(names.size())));
            country.setContinent(continents.get(rand.nextInt(continents.size())));
            countries.add(country);
        }
        return countries;
    }

    private List<Book> generateBooks(int numBooks, List<Author> authors) {
        List<String> titles = Arrays.asList("The Great Gatsby", "To Kill a Mockingbird", "1984", "Pride and Prejudice", "The Lord of the Rings", "The Catcher in the Rye", "Animal Farm");
        List<Book> books = new ArrayList<>();
        List<Author> authorList = authorRepository.findAll();
        for (int i = 0; i < numBooks; i++) {
            Book book = new Book();
            book.setName(titles.get(rand.nextInt(titles.size())));
            book.setCategory(Category.values()[rand.nextInt(Category.values().length)]);
            book.setAuthor(authorList.get(rand.nextInt(authorList.size())));
            book.setQuantity(rand.nextInt(10) + 1);
            books.add(book);
        }
        return books;
    }
}