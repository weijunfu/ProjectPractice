package org.ijunfu.dao;

import org.ijunfu.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/23 00:04
 * @version 1.0.0
 *
 */

@Repository
public class BookDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Book> queryAll() {
        String sql = "select * from tb_book";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Book.class));
    }

    public int save(Book book) {
        String sql = "insert into tb_book(name, author, publisher, remarks) values(:name, :author, :publisher, :remarks)";

        MapSqlParameterSource ps = new MapSqlParameterSource();
        ps.addValue("name", book.getName());
        ps.addValue("author", book.getAuthor());
        ps.addValue("publisher", book.getPublisher());
        ps.addValue("remarks", book.getRemarks());

        return jdbcTemplate.update(sql, ps);
    }

    public int update(Book book) {
        String sql = "update tb_book set name=:name, author=:author, publisher=:publisher, remarks=:remarks where id=:id";
        MapSqlParameterSource ps = new MapSqlParameterSource();
        ps.addValue("id", book.getId());
        ps.addValue("name", book.getName());
        ps.addValue("author", book.getAuthor());
        ps.addValue("publisher", book.getPublisher());
        ps.addValue("remarks", book.getRemarks());
        return jdbcTemplate.update(sql, ps);
    }

    public int delete(Long id) {
        String sql = "delete from tb_book where id=:id";
        MapSqlParameterSource ps = new MapSqlParameterSource();
        ps.addValue("id", id);
        return jdbcTemplate.update(sql, ps);
    }
}
