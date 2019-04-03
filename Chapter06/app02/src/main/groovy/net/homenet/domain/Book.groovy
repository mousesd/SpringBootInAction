package net.homenet.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@Entity
@ToString
class Book implements GormEntity<Book> {
    Reader reader
    String isbn
    String title
    String author
    String description
}
