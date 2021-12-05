package com.blazings.suanfa.sql.tujie.mybatisplusservice.mybatisplusserviceimp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.mapper.StudentMapper;
import com.blazings.suanfa.sql.tujie.mybatisplusservice.StudentIService;
import com.blazings.suanfa.sql.tujie.vo.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentIServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentIService {
}
