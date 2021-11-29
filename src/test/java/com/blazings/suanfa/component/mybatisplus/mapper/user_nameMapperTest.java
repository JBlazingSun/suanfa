package com.blazings.suanfa.component.mybatisplus.mapper;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blazings.suanfa.component.mybatisplus.service.impl.user_nameServiceImpl;
import com.blazings.suanfa.component.mybatisplus.vo.user_name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class user_nameMapperTest {
    @Autowired
    user_nameMapper user_nameMapper;

    @Autowired
    user_nameServiceImpl user_nameService;

    @Test
    public void test() {
        TimeInterval timer = DateUtil.timer();

//---------------------------------
//-------这是执行过程
        List<user_name> user_nameList = user_nameMapper.selectList(Wrappers.emptyWrapper());
//---------------------------------

        System.out.println(timer.interval());
        System.out.println(user_nameList);
    }

    @Test
    void user_nameServiceImplTest() {
        IPage<user_name> userPage = new Page<>(1,4);
        IPage<user_name> user_nameIPage = user_nameMapper.selectPage(userPage, null);
        System.out.println("user_nameIPage = " + user_nameIPage);
        System.out.println("user_nameService.count() = " + user_nameService.count());
    }
}