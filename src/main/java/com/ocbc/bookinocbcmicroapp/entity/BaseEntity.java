package com.ocbc.bookinocbcmicroapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private Long id;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    private Date deleteTime;
}
