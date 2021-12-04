package com.blazings.suanfa.sql.tujie.mapper;

import com.blazings.suanfa.sql.tujie.vo.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class CourseMapperTest {
    @Autowired
    CourseMapper courseMapper;

    @Test
    public void CourseMapperT() {
        List<Course> courses = courseMapper.selectList(null);
        System.out.println(courses);
    }
}