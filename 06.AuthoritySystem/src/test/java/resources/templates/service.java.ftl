package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 *
 * @Title          <h2>业务类</h2>
 * @Description    <p>${table.comment!}</p>
 *
 * @author         ${author}
 * @date           ${date}
 * @version        1.0.0
 *
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
