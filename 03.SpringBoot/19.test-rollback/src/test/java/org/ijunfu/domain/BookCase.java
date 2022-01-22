package org.ijunfu.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/22 13:24
 * @version 1.0.0
 *
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {

    private int id;
    private String name;
    private String uuid;
    private long publishTime;
}
