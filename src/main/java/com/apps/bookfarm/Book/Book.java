package com.apps.bookfarm.Book;


import com.apps.bookfarm.Author.Author;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name= "Book")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column( name ="Book_ID")
    private Long bookId;
    @Column(name="Book_Title")
    private String title;
    @OneToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;
    @Column (name = "Book_Publisher")
    private String Publisher;
    @Column (name = "Book_ISBN")
    private int isbn;
    @Column (name = "Book_Length")
    private int length;
    @Column (name = "Book_Subject")
    private String subject;

   public Book(String title,Author author,String Publisher,int isbn,int length,String subject){
       this.bookId =bookId;
       this.title = title;
       this.author=author;
       this.Publisher= Publisher;
       this.isbn = isbn;
       this.length= length;
       this.subject= subject;
   }

    public Book() {

    }


    public Long getBookId(){
       return bookId;
   }
   public void setBookId(Long bookId){
       this.bookId = bookId;
   }
   public String getTitle(){
       return title;
   }
   public void setTitle(String title){
       this.title= title;
   }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor (Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {

       this.isbn = isbn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", Publisher='" + Publisher + '\'' +
                ", isbn=" + isbn +
                ", length=" + length +
                ", subject='" + subject + '\'' +
                '}';
    }
}
