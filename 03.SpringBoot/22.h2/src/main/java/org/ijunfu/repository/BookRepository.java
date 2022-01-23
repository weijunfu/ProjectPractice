package org.ijunfu.repository;

import org.ijunfu.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/23 19:40
 * @version 1.0.0
 *
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
