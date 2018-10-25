package com.ow.tracer.auth.service.impl;

import com.ow.tracer.core.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther: Easy
 * @Date: 18-9-21 22:37
 * @Description:
 */

public interface UserService {
    UserVO findUserByUsername(@PathVariable("username") String username);
}
