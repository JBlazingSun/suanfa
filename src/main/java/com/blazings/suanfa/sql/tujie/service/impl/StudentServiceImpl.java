package com.blazings.suanfa.sql.tujie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.dao.StudentDao;
import com.blazings.suanfa.sql.tujie.entity.Student;
import com.blazings.suanfa.sql.tujie.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * (Student)�����ʵ����
 *
 * @author makejava
 * @since 2021-12-16 21:50:02
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}

