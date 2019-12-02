package com.mybatisplus.demo.service.impl;

import com.mybatisplus.demo.model.PeopleTest;
import com.mybatisplus.demo.mapper.PeopleTestMapper;
import com.mybatisplus.demo.service.PeopleTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sun
 * @since 2019-12-02
 */
@Service
public class PeopleTestServiceImpl extends ServiceImpl<PeopleTestMapper, PeopleTest> implements PeopleTestService {

}
