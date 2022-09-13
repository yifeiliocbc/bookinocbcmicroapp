package com.ocbc.bookinocbcmicroapp.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookVO {
    private Long id;

    private String title;

    private String author;

    private String summary;

    private String image;
}
