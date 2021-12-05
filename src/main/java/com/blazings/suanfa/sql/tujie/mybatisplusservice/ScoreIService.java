package com.blazings.suanfa.sql.tujie.mybatisplusservice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blazings.suanfa.sql.tujie.vo.Score;

public interface ScoreIService extends IService<Score> {
    /**
     * 查询课程编号为“0002”的总成绩
     * @return
     */
    public float GetCourseideq2TotalScore();
}
