package org.ijunfu.domain;

import lombok.Data;

import java.util.Date;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/24 21:36
 * @version 1.0.0
 *
 */

@Data
public class Book {

    private Long id;
    private String name;
    private String author;
    private Date publishTime;
    private Double price;
    private String remarks;
}
