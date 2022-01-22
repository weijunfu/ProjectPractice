package org.ijunfu.domain;

import lombok.Data;

/**
 *
 * @Title          Book
 * @Description    JavaBean
 *
 * @author weijunfu<ijunfu@163.com>
 * @date 2022/01/23 00:02
 * @version 1.0.0
 *
 */

@Data
public class Book {

    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String remarks;
}
