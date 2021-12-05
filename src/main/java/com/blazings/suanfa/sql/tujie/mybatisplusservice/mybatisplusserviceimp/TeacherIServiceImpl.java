package com.blazings.suanfa.sql.tujie.mybatisplusservice.mybatisplusserviceimp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.mapper.TeacherMapper;
import com.blazings.suanfa.sql.tujie.mybatisplusservice.TeacherIService;
import com.blazings.suanfa.sql.tujie.vo.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherIServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherIService {

}
