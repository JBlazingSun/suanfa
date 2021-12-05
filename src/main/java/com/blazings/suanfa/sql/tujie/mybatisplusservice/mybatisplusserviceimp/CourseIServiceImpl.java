package com.blazings.suanfa.sql.tujie.mybatisplusservice.mybatisplusserviceimp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.mapper.CourseMapper;
import com.blazings.suanfa.sql.tujie.mybatisplusservice.CourseIService;
import com.blazings.suanfa.sql.tujie.vo.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseIServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseIService {

}
