package org.ijunfu.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu@qq.com>
 * @date 2022/02/05 12:37
 * @version 1.0.0
 *
 */

@Data
public class LoginDTO implements Serializable {

    private String username;
    private String password;

}
