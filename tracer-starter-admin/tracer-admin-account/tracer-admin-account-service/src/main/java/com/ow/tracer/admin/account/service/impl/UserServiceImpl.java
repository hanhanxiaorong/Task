package com.ow.tracer.admin.account.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ow.tracer.admin.account.dto.Role;
import com.ow.tracer.admin.account.dto.User;
import com.ow.tracer.admin.account.dto.UserInfo;
import com.ow.tracer.admin.account.mapper.UserMapper;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.service.IUserService;
import com.ow.tracer.core.constats.SecurityConstants;
import com.ow.tracer.core.vo.AdminRole;
import com.ow.tracer.core.vo.MenuVO;
import com.ow.tracer.core.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: Easy
 * @Date: 18-9-10 21:56
 * @Description:
 */
@Service("iUserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private IMenuService menuService;
    @Override
    public UserInfo getUserInfo(UserVO userVO) {
        User usertion = new User();
        usertion.setUserName(userVO.getUserName());
        User user =  this.getOne(new QueryWrapper<>(usertion));
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        List<AdminRole> roleList = userVO.getRoleList();
        List<String> roleNames = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(roleList)) {
            for (AdminRole sysRole : roleList) {
                if (!StrUtil.equals(SecurityConstants.BASE_ROLE, sysRole.getRoleName())) {
                    roleNames.add(sysRole.getRoleName());
                }
            }
        }
        String[] roles = roleNames.toArray(new String[roleNames.size()]);
        userInfo.setRoles(roles);
        Set<MenuVO> menuVoSet = new HashSet<>();
        for (String role : roles) {
            List<MenuVO> menuVos = menuService.findMenuByRoleName(role);
            menuVoSet.addAll(menuVos);
        }
        Set<String> permissions = new HashSet<>();
        for (MenuVO menuVo : menuVoSet) {
            if (StringUtils.isNotEmpty(menuVo.getPermission())) {
                String permission = menuVo.getPermission();
                permissions.add(permission);
            }
        }
        userInfo.setPermissions(permissions.toArray(new String[permissions.size()]));
        return userInfo;
    }

    @Override
    public IPage<UserVO> selectUserPage(Page<UserVO> page) {
        return         this.baseMapper.selectPageVo(page);

    }
}
