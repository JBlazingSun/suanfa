package com.example.mybatisplus.userpagination.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.userpagination.dao.ChildrenDao;
import com.example.mybatisplus.userpagination.entity.Children;
import com.example.mybatisplus.userpagination.service.ChildrenService;
import org.springframework.stereotype.Service;

/**
 * (Children)�����ʵ����
 *
 * @author makejava
 * @since 2021-12-16 20:12:15
 */
@Service("childrenService")
public class ChildrenServiceImpl extends ServiceImpl<ChildrenDao, Children> implements ChildrenService {

}

