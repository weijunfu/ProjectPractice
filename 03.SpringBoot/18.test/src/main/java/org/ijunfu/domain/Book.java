package org.ijunfu.domain;

import lombok.Data;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/21 23:57
 * @version 1.0.0
 *
 */

@Data
public class Book {

    private Integer id;
    private String name;
    private String author;
    private String type;
    private String remarks;
}
