package com.elasticsearch.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * <p>
 *  实体
 * </p>
 *
 * @author wangliang
 * @since 2017/8/17
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "liang", type = "books")
public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private String releaseDate;

}