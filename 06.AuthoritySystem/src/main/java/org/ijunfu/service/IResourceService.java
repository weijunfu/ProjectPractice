package org.ijunfu.service;

import org.ijunfu.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ijunfu.vo.Tree;

import java.util.List;

/**
 *
 * @Title          <h2>业务类</h2>
 * @Description    <p></p>
 *
 * @author         ijunfu
 * @date           2022-02-05 16:01
 * @version        1.0.0
 *
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> listBy(Long roleId);

    List<Tree> resourcesList();
}
