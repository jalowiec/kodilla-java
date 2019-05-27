package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;



    public Book(final String author, final String title, final int publicationYear) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;

    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publicationYear != book.publicationYear) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + publicationYear;
        return result;
    }
}