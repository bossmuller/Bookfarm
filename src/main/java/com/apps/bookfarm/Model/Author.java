package com.apps.bookfarm.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name= "AUTHOR")

public class Author {
    @Id

    @Column (name = "AUTHOR_ID")
    private Long authorId;
    @Column (name = "Author_Name")
    private String authorName;
    @Column (name="Phone_Number")
    private int phoneNumber;

    public Author(Long authorId, String authorName, int phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.authorId = authorId;
        this.authorName = authorName;


    }

    public Author() {

    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {

        this.authorId = authorId;
    }

    public String getAuthorName()

    {
        return authorName;
    }

    public void setAuthorName(String authorName) {

        this.authorName = authorName;
    }

    public int getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
