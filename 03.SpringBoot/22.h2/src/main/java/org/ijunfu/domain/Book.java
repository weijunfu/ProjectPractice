package org.ijunfu.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * @Title          Book
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/23 19:36
 * @version 1.0.0
 *
 */

@Data
@Entity
@Table(name = "tb_book")    // 定义表名
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String remarks;
}
