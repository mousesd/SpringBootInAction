package net.homenet

import grails.persistence.Entity

@Entity
class Book {
    Reader reader
    String isbn
    String title
    String author
    String description
}
