package org.ijunfu.dao.impl;

import org.ijunfu.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/15 21:48
 * @version 1.0.0
 *
 */

@Repository
public class BookDaoImpl implements BookDao {

    final static Logger log = LoggerFactory.getLogger(BookDaoImpl.class);

    @Override
    public void save() {

        log.info("保存图书成功");
    }
}
