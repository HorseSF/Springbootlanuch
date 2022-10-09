package com.horsesf.bootlanuch.model;



import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Article {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
}
