package com.ocbc.bookinocbcmicroapp.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Where(clause = "delete_time is null")
@SQLDelete(sql = "update ocbc_book set delete_time = now() where id = ?")
@Table(name = "ocbc_book")
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String summary;

    private String image;
}
