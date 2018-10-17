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
import com.ow.tracer.admin.account.dto.UserRole;
import com.ow.tracer.admin.account.mapper.UserMapper;
import com.ow.tracer.admin.account.service.IMenuService;
import com.ow.tracer.admin.account.service.IRoleService;
import com.ow.tracer.admin.account.service.IUserRoleService;
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
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IRoleService roleService;
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
    public IPage<User> selectUserPage(Page<User> page) {
        IPage<User> iPage = this.baseMapper.selectPage(page,null);
        for(User user :iPage.getRecords()){

            QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",user.getId());
           List<UserRole> userRoles = userRoleService.list(queryWrapper);
            String[] roleStr = new String[userRoles.size()];
           int i=0;
           for(UserRole userRole:userRoles){
                    Role role = roleService.getById(userRole.getRoleId());
                    System.out.println(role.getRoleName());
                    roleStr[i]=role.getRoleName() ;
                    i++;
           }
            user.setRoleStr(roleStr);
        }
        return iPage;

    }
}
