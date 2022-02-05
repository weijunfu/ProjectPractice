package org.ijunfu.controller.form;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/05 18:29
 * @version 1.0.0
 *
 */

@Data
public class LoginForm implements Serializable {

    private String username;
    private String password;

}
