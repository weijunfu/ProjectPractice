package org.ijunfu.domain;

import lombok.Data;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/22 12:36
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
