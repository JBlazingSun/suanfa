package com.blazings.suanfa.sql.tujie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.dao.StudentDao;
import com.blazings.suanfa.sql.tujie.entity.Student;
import com.blazings.suanfa.sql.tujie.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * (Student)??????????
 *
 * @author makejava
 * @since 2022-01-07 15:13:25
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}

