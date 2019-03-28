package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){
        //given
        Library library = new Library("Moja biblioteka");
        Book krolestwo = new Book("Krolestwo", "Szczepan Twardoch", LocalDate.of(2018, 8, 03));
        Book rudowlosa = new Book("Rudowlosa", "Orhan Pamuk", LocalDate.of(2018, 3, 15));
        Book opowiadania = new Book("Opowiadania bizarne", "Olga Tokarczuk", LocalDate.of(2017,6,6));
        library.getBooks().add(krolestwo);
        library.getBooks().add(rudowlosa);
        library.getBooks().add(opowiadania);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(rudowlosa);
        library.getBooks().remove(krolestwo);
        Book fajrant = new Book("Fajrant", "Andrzej Muszynski", LocalDate.of(2015,5,5));
        library.getBooks().add(fajrant);
        deepClonedLibrary.getBooks().add(fajrant);


        //Then
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, clonedLibrary.getBooks().size());
        Assert.assertEquals(4, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks(), clonedLibrary.getBooks());
        Assert.assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
        Assert.assertEquals(library.getName(), clonedLibrary.getName());
        Assert.assertEquals(library.getName(), deepClonedLibrary.getName());

    }
}
