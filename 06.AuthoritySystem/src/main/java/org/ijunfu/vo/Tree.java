package org.ijunfu.vo;

import lombok.Data;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/08 14:07
 * @version 1.0.0
 *
 */

@Data
public class Tree {

    private Long id;
    private String title;
    private List<Tree> children;
    private boolean checked;
}
