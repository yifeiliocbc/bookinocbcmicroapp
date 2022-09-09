package com.ocbc.bookinocbcmicroapp.entity;

import lombok.Data;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@Data
public class Book extends BaseEntity {

    private String title;

    private String author;

    private String summary;

    private String image;
}
