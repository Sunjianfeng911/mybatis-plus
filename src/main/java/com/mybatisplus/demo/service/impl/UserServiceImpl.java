package com.mybatisplus.demo.service.impl;

import com.mybatisplus.demo.model.User;
import com.mybatisplus.demo.mapper.UserMapper;
import com.mybatisplus.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Sun
 * @since 2019-12-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
