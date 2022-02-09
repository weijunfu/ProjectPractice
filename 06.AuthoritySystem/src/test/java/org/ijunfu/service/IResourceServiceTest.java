package org.ijunfu.service;

import org.ijunfu.entity.Resource;
import org.ijunfu.vo.Tree;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/05 23:29
 * @version 1.0.0
 *
 */
@SpringBootTest
class IResourceServiceTest {

    @Autowired
    private IResourceService resourceService;

    @Test
    void list() {
        List<Resource> list = resourceService.listBy(1l);
        System.out.println(list);
    }

    @Test
    void list2() {
        List<Tree> trees = resourceService.resourcesList(null);
        System.out.println(trees);
    }
}