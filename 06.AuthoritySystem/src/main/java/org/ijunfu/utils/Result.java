package org.ijunfu.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/07 00:13
 * @version 1.0.0
 *
 */

public class Result {

    /**
     * 
     * @Title       buildPage
     * @Description 构建分页查询的结果
     * 
     * @author      weijunfu<ijunfu@qq.com>
     * @date        2022/02/07 00:16
     * @version     1.0.0
     * @param 		page
     * @Return      org.ijunfu.utils.Response<java.util.concurrent.ConcurrentHashMap<java.lang.String,java.lang.Object>>
     */
    public static Response<ConcurrentHashMap<String, Object>> buildPage(IPage<?> page) {
        ConcurrentHashMap<String, Object> map =new ConcurrentHashMap<>();
        map.put("count", page.getTotal());
        map.put("records", page.getRecords());

        return Response.ok(map);
    }
}
