package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

public class BookSignature {
    private final String signature;

    public BookSignature(final String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookSignature that = (BookSignature) o;

        return signature != null ? signature.equals(that.signature) : that.signature == null;
    }

    @Override
    public int hashCode() {
        return signature != null ? signature.hashCode() : 0;
    }
}
