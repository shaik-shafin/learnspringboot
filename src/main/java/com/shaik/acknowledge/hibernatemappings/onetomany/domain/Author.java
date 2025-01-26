package com.shaik.acknowledge.hibernatemappings.onetomany.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
//Called Inverse Side because it doesn't hold FK of book
@Entity
@Table(name = "author")
@Cache(usage = NONSTRICT_READ_WRITE)
//This is annotation is for JsonIdentity in order to avoid infinite parsing by json
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "authorId")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Column(name = "author_name")
    private String authorName;

    //if you don't put orphanRemoval = true then if you remove an child entity in collection
    // then the fk in child table will set to null but if you want to delete it then put it to true
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    //name => use fk in snack casing(table format) and Optional -> referenceColumnName => use camel casing (domain format)
    //@JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private List<Book> book = new ArrayList<>();

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
        for(Book bk : this.book) {
            bk.setAuthor(this);
        }
    }
}
