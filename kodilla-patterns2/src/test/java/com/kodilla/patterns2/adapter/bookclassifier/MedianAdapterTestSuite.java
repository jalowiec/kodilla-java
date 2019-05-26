package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianEvenTest(){
        // Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Autor1", "Tytul 1", 1976, "1"));
        bookSet.add(new Book("Autor2", "Tytul 2", 1980, "2"));
        bookSet.add(new Book("Autor3", "Tytul 4", 2010, "4"));
        bookSet.add(new Book("Autor4", "Tytul 5", 2000, "5"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2000, median);

    }


    @Test
    public void publicationYearMedianOddTest(){
        // Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Autor1", "Tytul 1", 1976, "1"));
        bookSet.add(new Book("Autor2", "Tytul 2", 1980, "2"));
        bookSet.add(new Book("Autor1", "Tytul 3", 2000, "3"));
        bookSet.add(new Book("Autor3", "Tytul 4", 2010, "4"));
        bookSet.add(new Book("Autor3", "Tytul 4", 1990, "4"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(1990, median);



    }



}
