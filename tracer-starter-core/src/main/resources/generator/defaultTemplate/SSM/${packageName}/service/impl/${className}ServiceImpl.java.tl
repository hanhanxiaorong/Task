package com.hzf.${data.projectName}.${data.packageName}.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.${data.packageName}.dto.${data.className};
import com.ow.tracer.${data.packageName}.mapper.${data.className}Mapper;
import com.ow.tracer.${data.packageName}.service.${data.className}Service;
import com.ow.tracer.core.constats.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:     [${data.describe}业务接口实现类]
 * 创建人:     [${data.author}]
 * 创建时间:   [${date(),"yyyy-MM-dd HH:mm:ss"}]
 * 版本:       [v1.0]
 */
\@Service()
public class ${data.className}ServiceImpl extends ServiceImpl<${data.className}Mapper, ${data.className}> implements I${data.className}Service {


}
